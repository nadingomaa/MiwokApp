package com.example.android.miwokapp;

public class Word {
    private String miwokTranslation;
    private String defaultTranslation;
    private int imageResourseId=NO_IMAGE;
    private static final int NO_IMAGE=-1;

    public Word(String miwokTranslation, String defaultTranslation) {
        this.miwokTranslation = miwokTranslation;
        this.defaultTranslation = defaultTranslation;
    }


    public Word(String miwokTranslation, String defaultTranslation, int imageResourseId) {
        this.miwokTranslation = miwokTranslation;
        this.defaultTranslation = defaultTranslation;
        this.imageResourseId = imageResourseId;
    }


    public String getMiwokTranslation() {
        return miwokTranslation;
    }


    public String getDefaultTranslation() {
        return defaultTranslation;
    }


    public int getImageResourseId() {
        return imageResourseId;
    }

    public Boolean haveImage(){
        return imageResourseId!=NO_IMAGE;
    }
}
