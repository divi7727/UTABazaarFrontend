package com.example.android.utabazzar;

import java.util.Date;

/**
 * Created by deviprasadtripathy on 4/15/18.
 */

public class Messaging {
    private String messageText;
    private String messageUser;
    private long messageTime;

    public Messaging(String messageText, String messageUser){
        this.messageText = messageText;
        this.messageUser = messageUser;

        messageTime = new Date().getTime();
    }
    public Messaging(){

    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getMessageUser() {
        return messageUser;
    }

    public void setMessageUser(String messageUser) {
        this.messageUser = messageUser;
    }

    public long getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(long messageTime) {
        this.messageTime = messageTime;
    }

}
