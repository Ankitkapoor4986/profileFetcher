package com.ankit.socialProfileFetcher.appender;

import com.ankit.socialProfileFetcher.model.SocialProfiles;
import com.ankit.socialProfileFetcher.model.SocialSites;

public class SocialProfileAppender implements ProfileAppender<SocialProfiles> {


    private static ProfileAppender<SocialProfiles> socialProfilesProfileAppender = new SocialProfileAppender();

    @Override
    public SocialProfiles appendProfiles(String url) {

        int lastIndexForwardSlash = url.lastIndexOf("/");
        String username = url.substring(lastIndexForwardSlash);

        return new SocialProfiles(SocialSites.FACEBOOK.getUrl() + "/" + username,
                SocialSites.INSTAGRAM.getUrl() + "/" + username,
                SocialSites.PINTEST.getUrl() + "/" + username);

    }

    public static ProfileAppender<SocialProfiles> getSocialProfilesProfileAppender() {
        return socialProfilesProfileAppender;
    }
}
