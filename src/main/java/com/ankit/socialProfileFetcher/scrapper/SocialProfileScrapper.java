package com.ankit.socialProfileFetcher.scrapper;

import com.ankit.socialProfileFetcher.model.SocialProfiles;
import com.ankit.socialProfileFetcher.model.SocialSiteUrl;
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
        List<String> socialProfileLink = linkSearcher.searchLinks(allElements);
        if (socialProfileLink.isEmpty()) {
            return new SocialProfilesHolder(false);
        } else {
            SocialProfilesHolder socialProfilesHolder = new SocialProfilesHolder(true);
            fillSocialProfileHolder(socialProfilesHolder, socialProfileLink);
            return socialProfilesHolder;
        }

    }

    private void fillSocialProfileHolder(SocialProfilesHolder socialProfilesHolder, List<String> socialProfileLink) {
        SocialProfiles socialProfiles = new SocialProfiles();
        fillFBSocialProfile(socialProfileLink, socialProfiles);
        fillInstaSocialProfile(socialProfileLink, socialProfiles);
        fillPinTestSocialProfile(socialProfileLink, socialProfiles);

    }

    private void fillPinTestSocialProfile(List<String> socialProfileLink, SocialProfiles socialProfiles) {
        Optional<String> pintestProfileOptional = getSocialSiteUrl(socialProfileLink, SocialSiteUrl.PINTEST);
        if (pintestProfileOptional.isPresent()) {
            socialProfiles.setPinTest(pintestProfileOptional.get());
        }
    }

    private void fillInstaSocialProfile(List<String> socialProfileLink, SocialProfiles socialProfiles) {
        Optional<String> instaProfileOp = getSocialSiteUrl(socialProfileLink, SocialSiteUrl.INSTAGRAM);
        if (instaProfileOp.isPresent()) {
            socialProfiles.setInstagram(instaProfileOp.get());
        }
    }

    private void fillFBSocialProfile(List<String> socialProfileLink, SocialProfiles socialProfiles) {
        Optional<String> fbUrlOptional = getSocialSiteUrl(socialProfileLink, SocialSiteUrl.FACEBOOK);
        if (fbUrlOptional.isPresent()) {
            socialProfiles.setFacebook(fbUrlOptional.get());
        }
    }

    private Optional<String> getSocialSiteUrl(List<String> socialProfileLink, SocialSiteUrl socialSiteUrl) {
        return socialProfileLink.stream().filter(link -> socialSiteUrl.getUrl().equals(link))
                .findFirst();
    }


    public static Scrapper<SocialProfilesHolder> getInstance() {
        return scrapper;
    }


}
