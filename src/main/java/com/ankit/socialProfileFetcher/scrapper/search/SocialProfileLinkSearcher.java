package com.ankit.socialProfileFetcher.scrapper.search;

import com.ankit.socialProfileFetcher.model.SocialSites;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SocialProfileLinkSearcher implements LinkSearcher {

    private static LinkSearcher linkSearcher = new SocialProfileLinkSearcher();

    @Override
    public List<String> searchLinks(Elements allElements) {
        List<Element> links = new ArrayList<>();
        enrichLinks(allElements,links);
        return getSocialSiteLink(links);

    }

    private List<String> getSocialSiteLink(List<Element> links) {
       return links.stream()
                .map(element -> element.attr("href"))
                .filter(this::isSocialSiteUrl)
                .collect(Collectors.toList());
    }

    private boolean isSocialSiteUrl(String link) {

       return Arrays.stream(SocialSites.values())
                .anyMatch(socialSites -> link.contains(socialSites.getSiteName()));
    }
    //recussion
    private void enrichLinks(Elements allElements, List<Element> linkElements) {

        allElements.stream().filter(el -> !hasChildNodes(el)).filter(el -> el.is("a[href]"))
                .forEach(linkElements::add);

        allElements.stream().filter(this::hasChildNodes).forEach(el -> enrichLinks(el.children(), linkElements));


    }

    private boolean hasChildNodes(Element element) {
        return element.childNodeSize() >= 1;
    }

    public static LinkSearcher getLinkSearcher() {
        return linkSearcher;
    }
}
