package com.qa.utils;

public class EnvironmentResolver {

    public String resolvePropertiesFileName() {
        String environment = System.getProperty("env", "beta");
        return "configs/" + environment + ".properties";
    }
}
