package com.ankit.socialProfileFetcher.model;

public enum SocialSiteUrl {


    FACEBOOK("facebook"),INSTAGRAM("instagram"),PINTEST("pintest");

    private String url;

    SocialSiteUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
