package com.ankit.socialProfileFetcher.processor;

public interface ProfileFetcherProcessor<T> {

    T fetchProfiles(String url);

}
