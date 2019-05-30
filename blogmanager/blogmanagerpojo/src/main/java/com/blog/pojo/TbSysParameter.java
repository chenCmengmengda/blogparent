package com.blog.pojo;

public class TbSysParameter {
    private String cmsname;

    private String version;

    private String author;

    private String homepage;

    private String runserver;

    private String databaseversion;

    private String powerby;

    public String getCmsname() {
        return cmsname;
    }

    public void setCmsname(String cmsname) {
        this.cmsname = cmsname == null ? null : cmsname.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage == null ? null : homepage.trim();
    }

    public String getRunserver() {
        return runserver;
    }

    public void setRunserver(String runserver) {
        this.runserver = runserver == null ? null : runserver.trim();
    }

    public String getDatabaseversion() {
        return databaseversion;
    }

    public void setDatabaseversion(String databaseversion) {
        this.databaseversion = databaseversion == null ? null : databaseversion.trim();
    }

    public String getPowerby() {
        return powerby;
    }

    public void setPowerby(String powerby) {
        this.powerby = powerby == null ? null : powerby.trim();
    }
}