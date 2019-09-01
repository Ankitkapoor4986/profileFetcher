package com.ankit.socialProfileFetcher.appender;

import com.ankit.socialProfileFetcher.model.SocialProfiles;
import com.ankit.socialProfileFetcher.model.SocialSites;

public class SocialProfileAppender implements ProfileAppender<SocialProfiles> {


    private static final String FORWARD_SLASH = "/";
    private static ProfileAppender<SocialProfiles> socialProfilesProfileAppender = new SocialProfileAppender();

    @Override
    public SocialProfiles appendProfiles(String url) {

        int lastIndexForwardSlash = url.lastIndexOf(FORWARD_SLASH);
        String username = url.substring(lastIndexForwardSlash);

        String facebookUrl = SocialSites.FACEBOOK.getUrl()  + username;
        String instagramUrl = SocialSites.INSTAGRAM.getUrl()  + username;
        String pinTestUrl = SocialSites.PINTEST.getUrl()  + username;
        return new SocialProfiles(facebookUrl,instagramUrl,pinTestUrl);

    }

    public static ProfileAppender<SocialProfiles> getSocialProfilesProfileAppender() {
        return socialProfilesProfileAppender;
    }
}
