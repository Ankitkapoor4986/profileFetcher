package com.ankit.socialProfileFetcher.processor;

import com.ankit.socialProfileFetcher.model.SocialProfiles;
import com.ankit.socialProfileFetcher.model.holder.SocialProfilesHolder;
import com.ankit.socialProfileFetcher.scrapper.Scrapper;
import com.ankit.socialProfileFetcher.scrapper.SocialProfileScrapper;

public class SocialProfileFetcherProcessor implements ProfileFetcherProcessor<SocialProfiles> {

    private static Scrapper<SocialProfilesHolder> scrapper = SocialProfileScrapper.getInstance();
    private static ProfileFetcherProcessor<SocialProfiles> processor = new SocialProfileFetcherProcessor();


    public SocialProfiles fetchProfiles(String url) {

        SocialProfilesHolder socialProfilesHolder = scrapper.scrapeUrl(url);
        socialProfilesHolder.isValueFound();

        return null;
    }

    public static ProfileFetcherProcessor getInstance() {
        return processor;

    }
}
