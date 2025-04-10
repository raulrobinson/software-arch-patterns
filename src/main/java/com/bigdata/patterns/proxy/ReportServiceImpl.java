package com.bigdata.patterns.proxy;

import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService {

    @Override
    public Report generateReport(String userId) {
        System.out.println("🔍 Generando reporte real para usuario: " + userId);
        return new Report("Reporte confidencial para " + userId);
    }
}
