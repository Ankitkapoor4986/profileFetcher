package com.ankit.socialProfileFetcher.model;

public enum SocialSites {

    FACEBOOK("facebook","www.facebook.com"),INSTAGRAM("instagram","www.instagram.com"),
    PINTEST("pintest","www.pintest.com");

    private final String url;
    private String siteName;

    SocialSites(String siteName, String url) {
        this.siteName = siteName;
        this.url= url;
    }

    public String getSiteName() {
        return siteName;
    }

    public String getUrl() {
        return url;
    }
}
