package com.example.infinaDemo.shortenedUrl;
import lombok.Data;

import java.util.Date;

@Data
public class ShortenedUrlDto {
    private long id;
    private String shortUrl;
    private String longUrl;
    private int hitStats;
    private Date createdAt;

    public static ShortenedUrlDto from(ShortenedUrl theUrl){
        ShortenedUrlDto urlDto = new ShortenedUrlDto();
        urlDto.setId(theUrl.getId());
        urlDto.setShortUrl(theUrl.getShortUrl());
        urlDto.setLongUrl(theUrl.getLongUrl());
        urlDto.setHitStats(theUrl.getHitStats());
        urlDto.setCreatedAt(theUrl.getCreatedAt());
        return urlDto;
    }

}
