package com.example.android.miwok;

/**
 * Created by Harsha on 07-01-2017.
 */
public class Word {
    //Word states
    private String miwokTranslation,defaultTranslation;
    private int imageId=NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED=-1;
    private int audioId;
   public Word(String english,String miwok,int audioId){
       miwokTranslation=miwok;
       defaultTranslation=english;
       this.audioId=audioId;
   }


    public Word(String english,String miwok,int imageId,int audioId){
        miwokTranslation=miwok;
        defaultTranslation=english;
        this.imageId=imageId;
        this.audioId=audioId;
    }
    //get the translations
    public String getMiwokTranslation(){
        return miwokTranslation;
    }
    public String getDefaultTranslation(){
        return defaultTranslation;
    }
    public int getImageId(){return imageId;}
    public int getAudioId(){return audioId;}
    public boolean hasImage(){
        return imageId != NO_IMAGE_PROVIDED;
    }
}
