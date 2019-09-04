package com.ankit.socialProfileFetcher.model;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public enum SocialSites {

    FACEBOOK("facebook", "www.facebook.com", (fb, socialProfileBuilder) ->
            socialProfileBuilder.addFacebook(fb)),
    INSTAGRAM("instagram", "www.instagram.com",
            (insta, socialProfileBuilder) -> socialProfileBuilder.addInstagram(insta)),
    PINTEST("pintest", "www.pintest.com",
            (pin, socialProfileBuilder) -> socialProfileBuilder.addPinTest(pin));

    private final String url;
    private String siteName;
    private BiConsumer<String, SocialProfileBuilder> socialProfileBuilderConsumer;

    SocialSites(String siteName, String url, BiConsumer<String, SocialProfileBuilder> socialProfileBuilderConsumer) {
        this.siteName = siteName;
        this.url = url;
        this.socialProfileBuilderConsumer = socialProfileBuilderConsumer;
    }

    public String getSiteName() {
        return siteName;
    }

    public String getUrl() {
        return url;
    }

    public BiConsumer<String, SocialProfileBuilder> getSocialProfileBuilderConsumer() {
        return socialProfileBuilderConsumer;
    }
}
