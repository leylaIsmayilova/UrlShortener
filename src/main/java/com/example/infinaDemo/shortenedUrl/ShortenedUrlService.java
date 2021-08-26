package com.example.infinaDemo.shortenedUrl;

import com.example.infinaDemo.shortenedUrl.exception.UrlNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ShortenedUrlService {

    @Autowired
    private ShortenedUrlRepository urlRep;


    public List<ShortenedUrl> getUrls() {
        return StreamSupport.stream( urlRep.findAll().spliterator(), false )
                .collect(Collectors.toList());
    }

    public ShortenedUrl getUrlById( Long id ){
        return urlRep.findById(id).orElseThrow(() -> new UrlNotFoundException( id ));
    }

    public ShortenedUrl getUrlByShort( String shortUrl ) {
        return /*urlRep.findByShortUrl(shortUrl).orElseThrow(() -> new UrlNotFoundException(shortUrl))*/ null;
    }

    public ShortenedUrl registerUrl( String longUrl){
        ShortenedUrl newUrl = new ShortenedUrl(longUrl);
        return urlRep.save(newUrl);
    }

    @Transactional
    public ShortenedUrl editUrl( Long id, ShortenedUrl url){
        ShortenedUrl urlToEdit = getUrlById(id);
        urlToEdit.setHitStats(url.getHitStats());
        urlToEdit.setShortUrl(url.getShortUrl());
        return  urlToEdit;
    }


}
