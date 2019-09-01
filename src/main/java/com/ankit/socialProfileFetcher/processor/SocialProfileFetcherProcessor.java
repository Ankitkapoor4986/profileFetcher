package com.ankit.socialProfileFetcher.processor;

import com.ankit.socialProfileFetcher.appender.ProfileAppender;
import com.ankit.socialProfileFetcher.appender.SocialProfileAppender;
import com.ankit.socialProfileFetcher.model.SocialProfiles;
import com.ankit.socialProfileFetcher.model.holder.SocialProfilesHolder;
import com.ankit.socialProfileFetcher.scrapper.Scrapper;
import com.ankit.socialProfileFetcher.scrapper.SocialProfileScrapper;
import com.ankit.socialProfileFetcher.util.UrlUtil;

import java.util.Optional;

public class SocialProfileFetcherProcessor implements ProfileFetcherProcessor<SocialProfiles> {

    private static Scrapper<SocialProfilesHolder> scrapper = SocialProfileScrapper.getScrapper();
    private static ProfileFetcherProcessor<SocialProfiles> processor = new SocialProfileFetcherProcessor();
    private static ProfileAppender<SocialProfiles> socialProfilesProfileAppender = SocialProfileAppender
            .getSocialProfilesProfileAppender();


    public SocialProfiles fetchProfiles(String url) {

        SocialProfilesHolder socialProfilesHolder = scrapper.scrapeUrl(url);
        SocialProfiles socialProfiles;
        if (socialProfilesHolder.isValueFound()) {
            socialProfiles = socialProfilesHolder.getSocialProfile();
        } else {
            socialProfiles = socialProfilesProfileAppender.appendProfiles(url);
        }

        return getValidatedSocialProfiles(socialProfiles);


    }

    private SocialProfiles getValidatedSocialProfiles(SocialProfiles socialProfiles) {
        Optional<String> fbUrl = getValidatedUrl(socialProfiles.getFacebook());
        Optional<String> instaUrl = getValidatedUrl(socialProfiles.getInstagram());
        Optional<String> pinTestUrl = getValidatedUrl(socialProfiles.getPinTest());

        return new SocialProfiles(fbUrl.orElse(""),instaUrl.orElse(""),pinTestUrl.orElse(""));
    }

    private Optional<String> getValidatedUrl(String url) {
        if(UrlUtil.isUrlHosted(url)){
            return Optional.of(url);
        }else {
            return Optional.empty();
        }

    }

    static ProfileFetcherProcessor getProcessor() {
        return processor;

    }
}
