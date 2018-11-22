package com.pep.restapi.healthcheck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ApplicationHealthIndicator extends AbstractHealthIndicator{
    private Environment env;

    @Autowired
    public ApplicationHealthIndicator(Environment env) {
        this.env = env;
    }

    @Override
    protected void doHealthCheck(Health.Builder builder) {
        builder.up();
        builder.withDetail("version", env.getProperty("app.version", "<none>"));
        builder.withDetail("environment", env.getProperty("app.environment", "<none>"));
        builder.withDetail("country", env.getProperty("app.country", "<none>"));
    }
}
