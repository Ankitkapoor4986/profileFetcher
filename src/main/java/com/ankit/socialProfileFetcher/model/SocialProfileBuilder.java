package com.ankit.socialProfileFetcher.model;

public class SocialProfileBuilder {

    private String facebook;
    private String instagram;
    private String pinTest;

    public SocialProfileBuilder addFacebook(String facebook){
        this.facebook = facebook;
        return this;
    }

    public SocialProfileBuilder addInstagram(String instagram){
        this.instagram = instagram;
        return this;
    }

    public SocialProfileBuilder addPinTest(String pinTest){
        this.pinTest = pinTest;
        return this;
    }

    public SocialProfiles build(){
        return new SocialProfiles(this.facebook,this.instagram,this.pinTest);
    }


}
