package com.boxmail.model;

public class Mail {
    String languages;
    String pageSize;
    String spamsFillter;
    String signature;

    public Mail(String languages, String pageSize, String spamsFillter, String signature) {
        this.languages = languages;
        this.pageSize = pageSize;
        this.spamsFillter = spamsFillter;
        this.signature = signature;
    }

    public Mail() {
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getSpamsFillter() {
        return spamsFillter;
    }

    public void setSpamsFillter(String spamsFillter) {
        this.spamsFillter = spamsFillter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "" +
                "languages='" + languages + '\'' +
                "\n pageSize='" + pageSize + '\'' +
                "\n spamsFillter='" + spamsFillter + '\'' +
                "\n signature='" + signature + '\'' +
                '}';
    }
}
