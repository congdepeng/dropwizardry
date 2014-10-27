package com.depeng.wizardry.app;

import com.depeng.wizardry.config.AppConfiguration;
import com.depeng.wizardry.health.AppHealthCheck;
import com.depeng.wizardry.resources.AppResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class AppApplication extends Application<AppConfiguration> {
    @Override
    public void initialize(Bootstrap<AppConfiguration> appConfigBootstrap) {
        System.out.println("initialize........");
    }

    @Override
    public void run(AppConfiguration appConfiguration, Environment environment) throws Exception {
        System.out.println("run........");
        environment.healthChecks().register("template check", new AppHealthCheck(appConfiguration.getTemplate()));

        AppResource appResource = new AppResource(appConfiguration.getTemplate(), appConfiguration.getDefaultName());
        environment.jersey().register(appResource);

    }

    public static void main(String[] args) throws Exception {
        AppApplication appApplication = new AppApplication();
        appApplication.run(args); // run call initialize()
    }
}
