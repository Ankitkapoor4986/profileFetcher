package com.ankit.socialProfileFetcher.model;

public class SocialProfiles {

    private String facebook;
    private String instagram;
    private String pinTest;

    public SocialProfiles(String facebook, String instagram, String pinTest) {
        this.facebook = facebook;
        this.instagram = instagram;
        this.pinTest = pinTest;
    }

    public String getFacebook() {
        return facebook;
    }


    public String getInstagram() {
        return instagram;
    }


    public String getPinTest() {
        return pinTest;
    }

}
