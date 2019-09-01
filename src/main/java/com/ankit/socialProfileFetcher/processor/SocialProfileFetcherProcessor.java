package com.ankit.socialProfileFetcher.processor;

import com.ankit.socialProfileFetcher.appender.ProfileAppender;
import com.ankit.socialProfileFetcher.appender.SocialProfileAppender;
import com.ankit.socialProfileFetcher.model.SocialProfiles;
import com.ankit.socialProfileFetcher.model.holder.SocialProfilesHolder;
import com.ankit.socialProfileFetcher.scrapper.Scrapper;
import com.ankit.socialProfileFetcher.scrapper.SocialProfileScrapper;

public class SocialProfileFetcherProcessor implements ProfileFetcherProcessor<SocialProfiles> {

    private static Scrapper<SocialProfilesHolder> scrapper = SocialProfileScrapper.getScrapper();
    private static ProfileFetcherProcessor<SocialProfiles> processor = new SocialProfileFetcherProcessor();
    private static ProfileAppender<SocialProfiles> socialProfilesProfileAppender = SocialProfileAppender
            .getSocialProfilesProfileAppender();


    public SocialProfiles fetchProfiles(String url) {

        SocialProfilesHolder socialProfilesHolder = scrapper.scrapeUrl(url);
        if(socialProfilesHolder.isValueFound()){
            return socialProfilesHolder.getSocialProfile();
        }

        return socialProfilesProfileAppender.appendProfiles(url);
    }

     static ProfileFetcherProcessor getProcessor() {
        return processor;

    }
}
