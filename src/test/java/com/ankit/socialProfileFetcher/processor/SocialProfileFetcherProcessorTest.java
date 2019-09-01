package com.ankit.socialProfileFetcher.processor;

import com.ankit.socialProfileFetcher.model.SocialProfiles;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SocialProfileFetcherProcessorTest {

    ProfileFetcherProcessor<SocialProfiles> profileFetcherProcessor = SocialProfileFetcherProcessor.getProcessor();

    @Test
    public void shouldFetchProfile(){

        SocialProfiles socialProfiles = profileFetcherProcessor.fetchProfiles("www.instagram.com/iamsrk");
        Assertions.assertTrue("www.instagram.com/iamsrk".equals(socialProfiles.getInstagram()));
        Assertions.assertTrue("www.facebook.com/iamsrk".equals(socialProfiles.getFacebook()));


    }

}