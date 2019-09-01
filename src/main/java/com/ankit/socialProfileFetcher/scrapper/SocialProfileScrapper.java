package com.ankit.socialProfileFetcher.scrapper;

import com.ankit.socialProfileFetcher.model.SocialProfileBuilder;
import com.ankit.socialProfileFetcher.model.SocialSites;
import com.ankit.socialProfileFetcher.model.holder.SocialProfilesHolder;
import com.ankit.socialProfileFetcher.scrapper.search.LinkSearcher;
import com.ankit.socialProfileFetcher.scrapper.search.SocialProfileLinkSearcher;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;
import java.util.Optional;

public class SocialProfileScrapper implements Scrapper<SocialProfilesHolder> {

    private static Scrapper<SocialProfilesHolder> scrapper = new SocialProfileScrapper();
    private static LinkSearcher linkSearcher = SocialProfileLinkSearcher.getLinkSearcher();

    public SocialProfilesHolder scrapeUrl(String url) {

        Document document = Jsoup.parse(url);
        Elements allElements = document.getAllElements();
        // jsoup support not used
        // Elements href = document.select("a[href]");
        // Elements linkhref = document.select("link[href]");
        List<String> socialProfileList = linkSearcher.searchLinks(allElements);
        if (socialProfileList.isEmpty()) {
            return new SocialProfilesHolder(false);
        } else {
            return buildSocialProfileHolder(socialProfileList);

        }

    }

    private SocialProfilesHolder buildSocialProfileHolder(List<String> socialProfileLink) {
        SocialProfileBuilder socialProfilesBuilder = new SocialProfileBuilder();
        addFbProfile(socialProfileLink, socialProfilesBuilder);
        addInstaProfile(socialProfileLink, socialProfilesBuilder);
        addPinTestProfile(socialProfileLink, socialProfilesBuilder);
        return new SocialProfilesHolder(socialProfilesBuilder.build(), true);


    }

    private void addPinTestProfile(List<String> socialProfileLink, SocialProfileBuilder socialProfileBuilder) {
        Optional<String> pintestProfileOptional = getSocialSiteUrl(socialProfileLink, SocialSites.PINTEST);
        pintestProfileOptional.ifPresent(socialProfileBuilder::addPinTest);
    }

    private void addInstaProfile(List<String> socialProfileLink, SocialProfileBuilder socialProfileBuilder) {
        Optional<String> instaProfileOp = getSocialSiteUrl(socialProfileLink, SocialSites.INSTAGRAM);
        instaProfileOp.ifPresent(socialProfileBuilder::addInstagram);
    }

    private void addFbProfile(List<String> socialProfileLink, SocialProfileBuilder socialProfiles) {
        Optional<String> fbUrlOptional = getSocialSiteUrl(socialProfileLink, SocialSites.FACEBOOK);
        fbUrlOptional.ifPresent(socialProfiles::addFacebook);
    }

    private Optional<String> getSocialSiteUrl(List<String> socialProfileLink, SocialSites socialSites) {
        return socialProfileLink.stream().filter(link -> socialSites.getSiteName().equals(link))
                .findFirst();
    }


    public static Scrapper<SocialProfilesHolder> getScrapper() {
        return scrapper;
    }


}
