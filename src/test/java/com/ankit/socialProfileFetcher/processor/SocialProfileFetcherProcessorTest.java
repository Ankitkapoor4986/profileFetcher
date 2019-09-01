package com.ankit.socialProfileFetcher.processor;

import com.ankit.socialProfileFetcher.model.SocialProfiles;
import org.junit.jupiter.api.Test;

class SocialProfileFetcherProcessorTest {

    ProfileFetcherProcessor<SocialProfiles> profileFetcherProcessor = SocialProfileFetcherProcessor.getProcessor();

    @Test
    public void shouldFetchProfile(){

        SocialProfiles socialProfiles = profileFetcherProcessor.fetchProfiles("https://www.instagram.com/iamsrk/");

    }

}