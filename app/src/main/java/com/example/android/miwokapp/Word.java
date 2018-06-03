package com.example.android.miwokapp;

public class Word {
    private String miwokTranslation;
    private String defaultTranslation;
    private  int audioResourseId;

    private int imageResourseId=NO_IMAGE;
    private static final int NO_IMAGE=-1;

    public int getAudioResourseId() {
        return audioResourseId;
    }

    public Word(String miwokTranslation, String defaultTranslation, int audioResourseId) {
        this.miwokTranslation = miwokTranslation;
        this.defaultTranslation = defaultTranslation;
        this.audioResourseId = audioResourseId;
    }

    public Word(String miwokTranslation, String defaultTranslation, int imageResourseId, int audioResourseId) {
        this.miwokTranslation = miwokTranslation;
        this.defaultTranslation = defaultTranslation;
        this.imageResourseId = imageResourseId;
        this.audioResourseId = audioResourseId;
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
