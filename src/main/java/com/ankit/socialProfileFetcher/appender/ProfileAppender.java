package com.ankit.socialProfileFetcher.appender;

public interface ProfileAppender<T> {

    T appendProfiles(String url);
}
