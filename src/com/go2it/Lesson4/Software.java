package com.go2it.Lesson4;

import java.time.LocalDate;

public class Software {
    private int version;
    private LocalDate date;
    private String developerOfVersion;

    public Software(int version) {
        this.version = version;
        this.date = LocalDate.now();
    }

    public Software(int version, LocalDate date, String developerOfVersion) {
        this.version = version;
        this.date = date;
        this.developerOfVersion = developerOfVersion;
    }

    public String getDeveloperOfVersion() {
        return developerOfVersion;
    }

    public void setDeveloperOfVersion(String developerOfVersion) {
        this.developerOfVersion = developerOfVersion;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
