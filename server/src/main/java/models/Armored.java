/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author ricardocazares
 */
@Document("Car")
public class Armored extends Car {
    int level;
    String certifiedFactory;
    String license;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getCertifiedFactory() {
        return certifiedFactory;
    }

    public void setCertifiedFactory(String certifiedFactory) {
        this.certifiedFactory = certifiedFactory;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }
    
    
}
