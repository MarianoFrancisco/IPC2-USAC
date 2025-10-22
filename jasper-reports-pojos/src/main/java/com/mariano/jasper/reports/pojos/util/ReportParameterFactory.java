package com.mariano.jasper.reports.pojos.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import com.mariano.jasper.reports.pojos.config.ReportPaths;

public class ReportParameterFactory {

    private ReportParameterFactory() {
    }

    public static Map<String, Object> createBaseParameters() {
        Map<String, Object> params = new HashMap<>();

        try (InputStream logo = ReportPaths.class.getResourceAsStream("/" + ReportPaths.LOGO_PATH)) {
            if (logo == null) {
                throw new IllegalStateException("Logo not found in classpath: " + ReportPaths.LOGO_PATH);
            }

            byte[] logoBytes = logo.readAllBytes();
            params.put("LOGO", logoBytes);

        } catch (IOException e) {
            throw new RuntimeException("Error reading logo resource", e);
        }

        return params;
    }
}
