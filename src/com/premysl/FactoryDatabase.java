package com.premysl;

/**
 * Created by Premysl Lefler on 28.4.17.
 */
public abstract class FactoryDatabase {
    private String filename;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
