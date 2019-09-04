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

import static com.ankit.socialProfileFetcher.model.SocialSites.PINTEST;

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
        addProfile(socialProfileLink, socialProfilesBuilder,SocialSites.FACEBOOK);
        addProfile(socialProfileLink, socialProfilesBuilder,SocialSites.INSTAGRAM);
        addProfile(socialProfileLink, socialProfilesBuilder,PINTEST);
        return new SocialProfilesHolder(socialProfilesBuilder.build(), true);
    }

    private void addProfile(List<String> socialProfileLink, SocialProfileBuilder socialProfileBuilder, SocialSites socialSites) {
        Optional<String> profileOptional = getSocialSiteUrl(socialProfileLink, socialSites);
        profileOptional.ifPresent((pintestProfile)-> socialSites.getSocialProfileBuilderConsumer().accept(pintestProfile,socialProfileBuilder));
    }


    private Optional<String> getSocialSiteUrl(List<String> socialProfileLink, SocialSites socialSites) {
        return socialProfileLink.stream().filter(link -> socialSites.getSiteName().equals(link))
                .findFirst();
    }


    public static Scrapper<SocialProfilesHolder> getScrapper() {
        return scrapper;
    }


}
