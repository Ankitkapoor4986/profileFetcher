package com.ankit.socialProfileFetcher.model.holder;

import com.ankit.socialProfileFetcher.model.SocialProfiles;

public class SocialProfilesHolder implements Holder<SocialProfiles> {

    private SocialProfiles socialProfiles;
    private boolean valueFound;

    public SocialProfilesHolder(SocialProfiles socialProfiles, boolean valueFound) {
        this.valueFound = valueFound;
        this.socialProfiles = socialProfiles;
    }

    public SocialProfilesHolder(boolean valueFound) {
        this.valueFound = valueFound;
    }

    public boolean isValueFound() {
        return valueFound;
    }

    public SocialProfiles getSocialProfile() {
        return socialProfiles;
    }
}
