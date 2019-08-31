package com.ankit.socialProfileFetcher.scrapper;

public interface Scrapper<T> {

   T scrapeUrl(String url);

}
