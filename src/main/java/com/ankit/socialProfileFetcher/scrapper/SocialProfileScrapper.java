package com.ankit.socialProfileFetcher.scrapper;

import com.ankit.socialProfileFetcher.model.SocialProfiles;
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
        //jsoup support
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
        SocialProfiles socialProfiles = new SocialProfiles();
        fillFBSocialProfile(socialProfileLink, socialProfiles);
        fillInstaSocialProfile(socialProfileLink, socialProfiles);
        fillPinTestSocialProfile(socialProfileLink, socialProfiles);
        return new SocialProfilesHolder(socialProfiles, true);


    }

    private void fillPinTestSocialProfile(List<String> socialProfileLink, SocialProfiles socialProfiles) {
        Optional<String> pintestProfileOptional = getSocialSiteUrl(socialProfileLink, SocialSites.PINTEST);
        if (pintestProfileOptional.isPresent()) {
            socialProfiles.setPinTest(pintestProfileOptional.get());
        }
    }

    private void fillInstaSocialProfile(List<String> socialProfileLink, SocialProfiles socialProfiles) {
        Optional<String> instaProfileOp = getSocialSiteUrl(socialProfileLink, SocialSites.INSTAGRAM);
        if (instaProfileOp.isPresent()) {
            socialProfiles.setInstagram(instaProfileOp.get());
        }
    }

    private void fillFBSocialProfile(List<String> socialProfileLink, SocialProfiles socialProfiles) {
        Optional<String> fbUrlOptional = getSocialSiteUrl(socialProfileLink, SocialSites.FACEBOOK);
        if (fbUrlOptional.isPresent()) {
            socialProfiles.setFacebook(fbUrlOptional.get());
        }
    }

    private Optional<String> getSocialSiteUrl(List<String> socialProfileLink, SocialSites socialSites) {
        return socialProfileLink.stream().filter(link -> socialSites.getSiteName().equals(link))
                .findFirst();
    }


    public static Scrapper<SocialProfilesHolder> getScrapper() {
        return scrapper;
    }


}
