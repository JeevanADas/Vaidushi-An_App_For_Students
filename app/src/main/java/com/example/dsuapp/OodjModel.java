package com.example.dsuapp;

public class OodjModel {

    String moduleLink, moduleName;

    public OodjModel(String moduleLink, String moduleName) {
        this.moduleLink = moduleLink;
        this.moduleName = moduleName;
    }

    public String getModuleLink() {
        return moduleLink;
    }

    public void setModuleLink(String moduleLink) {
        this.moduleLink = moduleLink;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public OodjModel() {
    }
}
