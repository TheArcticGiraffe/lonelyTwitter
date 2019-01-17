package ca.ualberta.cs.lonelytwitter.models;

import java.util.Date;

public class Sadness extends Mood {

    Sadness(){
        super.setDate(new Date(0));
    }

    Sadness(Date new_date){
        super.setDate(new_date);
    }


    public String getMood(){
        return "sadness";
    }
}
