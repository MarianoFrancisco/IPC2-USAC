package com.mariano.jasper.reports.pojos.util;

import java.io.InputStream;

import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author Mariano Camposeco {@literal (mariano1941@outlook.es)}
 */
public class ReportLoader {

    public JasperReport loadCompiled(String jasperClasspath) {
        try (InputStream in = getResource(jasperClasspath)) {
            if (in == null) {
                throw new IllegalArgumentException("JASPER not found: " + jasperClasspath);
            }
            return (JasperReport) JRLoader.loadObject(in);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load .jasper: " + jasperClasspath, e);
        }
    }

    private InputStream getResource(String path) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
    }
}
