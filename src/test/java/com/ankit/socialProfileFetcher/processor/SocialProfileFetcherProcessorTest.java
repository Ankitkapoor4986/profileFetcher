package com.ankit.socialProfileFetcher.processor;

import org.junit.jupiter.api.Test;

class SocialProfileFetcherProcessorTest {

    ProfileFetcherProcessor profileFetcherProcessor = SocialProfileFetcherProcessor.getInstance();

    @Test
    public void shouldFetchProfile(){

            profileFetcherProcessor.fetchProfiles("https://www.instagram.com/iamsrk/");
    }

}