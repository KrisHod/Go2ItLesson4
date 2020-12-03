package com.go2it.Lesson4;

import java.time.LocalDateTime;

public class Software {
    private int version;
    private LocalDateTime date;
    private String developerOfVersion;

    public Software(int version) {
        this.version = version;
        this.date = LocalDateTime.now();
    }

    public Software(int version, String developerOfVersion) {
        this.version = version;
        this.date = LocalDateTime.now();
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
