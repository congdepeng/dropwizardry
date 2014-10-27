package com.depeng.wizardry.health;

import com.codahale.metrics.health.HealthCheck;

public class AppHealthCheck extends HealthCheck {

    private final String template;

    public AppHealthCheck(String template) {
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        String test = String.format(template, "TEST");
        if (!test.contains("TEST")) {
            return Result.unhealthy("Template doesn't include a name");
        }

        return Result.healthy();
    }
}
