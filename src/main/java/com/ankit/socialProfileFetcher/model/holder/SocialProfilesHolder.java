package com.ankit.socialProfileFetcher.model.holder;

import com.ankit.socialProfileFetcher.model.SocialProfiles;
import com.ankit.socialProfileFetcher.model.holder.Holder;

public class SocialProfilesHolder implements Holder<SocialProfiles> {

    private SocialProfiles socialProfiles;
    private boolean valueFound;

    public boolean isValueFound() {
        return valueFound;
    }


    public SocialProfiles getSocialProfiles() {
        return socialProfiles;
    }
}
