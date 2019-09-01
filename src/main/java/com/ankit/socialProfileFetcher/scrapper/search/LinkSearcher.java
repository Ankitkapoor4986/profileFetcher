package com.ankit.socialProfileFetcher.scrapper.search;

import org.jsoup.select.Elements;

import java.util.List;

public interface LinkSearcher {

    List<String> searchLinks(Elements allElements);
}
