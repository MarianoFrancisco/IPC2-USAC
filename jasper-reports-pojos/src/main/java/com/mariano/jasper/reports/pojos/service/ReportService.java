package com.mariano.jasper.reports.pojos.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mariano.jasper.reports.pojos.domain.Employee;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author Mariano Camposeco {@literal (mariano1941@outlook.es)}
 */
public class ReportService {

    public <T> void exportWithDatasetParam(JasperReport report,
            String datasetParamName,
            List<T> data,
            String outputPath,
            Map<String, Object> parameters) {
        try {
            Map<String, Object> params = (parameters == null)
                    ? new HashMap<>()
                    : new HashMap<>(parameters);

            params.put(datasetParamName, new JRBeanCollectionDataSource(data));

            JasperPrint print = JasperFillManager.fillReport(report, params, new JREmptyDataSource());

            File out = new File(outputPath);
            File parent = out.getParentFile();
            if (parent != null) {
                parent.mkdirs();
            }

            JasperExportManager.exportReportToPdfFile(print, outputPath);
            System.out.println("PDF created: " + outputPath);
        } catch (JRException e) {
            System.out.println("Error generating report: " + e.getMessage());
        }
    }

    public void exportEmployeesToPdf(JasperReport report,
            List<Employee> employees,
            String outputPath,
            Map<String, Object> parameters) {
        exportWithDatasetParam(report, "employeeDataset", employees, outputPath, parameters);
    }
}
