package com.burakod.noticeboard;

/**
 * Created by BuraKod.
 */

public class Notice {



    private String author;
    private String subject;
    private String message;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }





    public Notice(){}

    public Notice(String name , String subject , String message){
        this.author = name;
        this.subject = subject;
        this.message = message;
    }
}
