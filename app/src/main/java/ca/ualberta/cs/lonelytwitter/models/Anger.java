package ca.ualberta.cs.lonelytwitter.models;

import java.util.Date;

public class Anger extends Mood {

    Anger(){
        super.setDate(new Date(0));
    }

    Anger(Date new_date){
        super.setDate(new_date);
    }


    public String getMood(){
        return "anger";
    }
}
