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

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getPinTest() {
        return pinTest;
    }

    public void setPinTest(String pinTest) {
        this.pinTest = pinTest;
    }
}
