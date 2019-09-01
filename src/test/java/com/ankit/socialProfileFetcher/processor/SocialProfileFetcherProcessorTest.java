package com.ankit.socialProfileFetcher.processor;

import com.ankit.socialProfileFetcher.model.SocialProfiles;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SocialProfileFetcherProcessorTest {

    ProfileFetcherProcessor<SocialProfiles> profileFetcherProcessor = SocialProfileFetcherProcessor.getProcessor();

    @Test
    public void shouldFetchProfile(){

        SocialProfiles socialProfiles = profileFetcherProcessor.fetchProfiles("instagram.com/iamsrk");
        Assertions.assertTrue("instagram.com/iamsrk".equals(socialProfiles.getInstagram()));

    }

}