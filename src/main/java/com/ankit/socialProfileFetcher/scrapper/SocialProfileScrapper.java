package com.ankit.socialProfileFetcher.scrapper;

import com.ankit.socialProfileFetcher.model.holder.SocialProfilesHolder;

public class SocialProfileScrapper implements Scrapper<SocialProfilesHolder> {

    private static Scrapper<SocialProfilesHolder> scrapper = new SocialProfileScrapper();

    public SocialProfilesHolder scrapeUrl(String url) {

        return null;
    }

    public static Scrapper<SocialProfilesHolder> getInstance(){
        return scrapper;
    }


}
