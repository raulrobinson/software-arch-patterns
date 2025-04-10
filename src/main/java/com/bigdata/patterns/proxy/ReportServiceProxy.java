package com.bigdata.patterns.proxy;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ReportServiceProxy implements ReportService {

    private final ReportServiceImpl realService;
    private final Map<String, Report> cache = new HashMap<>();

    public ReportServiceProxy(ReportServiceImpl realService) {
        this.realService = realService;
    }

    @Override
    public Report generateReport(String userId) {
        if (cache.containsKey(userId)) {
            System.out.println("🧠 Usando reporte cacheado para: " + userId);
            return cache.get(userId);
        }
        Report report = realService.generateReport(userId);
        cache.put(userId, report);
        return report;
    }
}
