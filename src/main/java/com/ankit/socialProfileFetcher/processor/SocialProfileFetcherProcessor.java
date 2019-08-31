package com.ankit.socialProfileFetcher.processor;

import com.ankit.socialProfileFetcher.model.SocialProfiles;
import com.ankit.socialProfileFetcher.model.holder.SocialProfilesHolder;
import com.ankit.socialProfileFetcher.scrapper.Scrapper;
import com.ankit.socialProfileFetcher.scrapper.SocialProfileScrapper;

public class SocialProfileFetcherProcessor implements ProfileFetcherProcessor<SocialProfiles> {

    private Scrapper<SocialProfilesHolder> scrapper = SocialProfileScrapper.getInstance();

    public SocialProfiles fetchProfiles(String url) {

        return null;
    }
}
