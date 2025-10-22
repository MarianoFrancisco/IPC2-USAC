package com.mariano.jasper.reports.pojos.config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 *
 * @author Mariano Camposeco {@literal (mariano1941@outlook.es)}
 */
public final class ReportPaths {

    private ReportPaths() {
    }

    public static final String EMPLOYEES_JASPER = "reports/employees.jasper";
    public static final String LOGO_PATH = "images/logo.png";
    public static final String OUT_DIR = "out/";

    public static final String OUT_PDF = OUT_DIR + generateUniqueFileName();

    private static String generateUniqueFileName() {
        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String uuid = UUID.randomUUID().toString().substring(0, 8);
        return String.format("employees-report_%s_%s.pdf", timestamp, uuid);
    }
}
