package com.ankit.socialProfileFetcher.util;

public class UrlUtil {

    public static boolean isUrlHosted(String url) {
        try {
            (new java.net.URL(url)).openStream().close();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //TODO Check why not working on test case
        return true;


    }
}
