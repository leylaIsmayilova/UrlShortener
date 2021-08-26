package com.example.infinaDemo.shortenedUrl.exception;

import java.text.MessageFormat;

public class UrlNotFoundException extends RuntimeException{

    public UrlNotFoundException( Long id){
        super(MessageFormat.format("Could not found registered url with id {0}", id));
    }

    public UrlNotFoundException( String shortUrl){
        super(MessageFormat.format("Could not found shortened url {0}", shortUrl));
    }


}
