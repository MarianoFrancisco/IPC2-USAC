package com.mariano.jasper.reports.pojos;

import java.util.Map;

import com.mariano.jasper.reports.pojos.config.ReportPaths;
import com.mariano.jasper.reports.pojos.repository.EmployeeRepository;
import com.mariano.jasper.reports.pojos.repository.InMemoryEmployeeRepository;
import com.mariano.jasper.reports.pojos.service.ReportService;
import com.mariano.jasper.reports.pojos.util.ReportLoader;
import com.mariano.jasper.reports.pojos.util.ReportParameterFactory;

import net.sf.jasperreports.engine.JasperReport;

public class JasperReportsPojos {

    public static void main(String[] args) {
        EmployeeRepository repository = new InMemoryEmployeeRepository();
        ReportLoader loader = new ReportLoader();
        ReportService reportService = new ReportService();

        JasperReport report = loader.loadCompiled(ReportPaths.EMPLOYEES_JASPER);

        Map<String, Object> params = ReportParameterFactory.createBaseParameters();

        reportService.exportEmployeesToPdf(report, repository.findAll(), ReportPaths.OUT_PDF, params);

        System.out.println("Report generated: " + ReportPaths.OUT_PDF);
    }
}
