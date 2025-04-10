package com.bigdata.patterns.proxy;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${controller.properties.base-path}/proxy")
@Tag(name = "Proxy", description = "Proxy operations")
public class ProxyController {

    private final ReportServiceProxy proxy;

    public ProxyController(ReportServiceProxy proxy) {
        this.proxy = proxy;
    }

    @GetMapping("/report/{userId}")
    @Operation(summary = "Proxy Pattern", description = "Get report using Proxy Pattern")
    @Parameter(name = "userId", description = "User ID", required = true, example = "USR123")
    public String getReport(@PathVariable String userId) {
        Report report = proxy.generateReport(userId);
        return report.getContent();
    }
}
