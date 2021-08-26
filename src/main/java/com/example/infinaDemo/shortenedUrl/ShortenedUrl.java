package com.example.infinaDemo.shortenedUrl;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
@Data
@Table( name = "RegisteredShortenedUrl")
public class ShortenedUrl {

    private static final AtomicInteger count = new AtomicInteger(0);
    private final int linkId = 1;

    @Id
    @SequenceGenerator(
            name = "seq_short_url",
            sequenceName = "seq_short_url",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_short_url"
    )
    private long id;
    private String shortUrl;
    private String longUrl;
    private int hitStats;
    private Date createdAt;

    public ShortenedUrl( String url) {
        shortUrl = shortenUrl();
        longUrl = url;
        hitStats = 0;
        createdAt = new Date();
    }


    public ShortenedUrl() {

    }

    public static ShortenedUrl from( ShortenedUrlDto urlDto){
        ShortenedUrl url = new ShortenedUrl();
        url.setShortUrl(urlDto.getShortUrl());
        url.setLongUrl(urlDto.getLongUrl());
        url.setHitStats(urlDto.getHitStats());
        url.setCreatedAt(urlDto.getCreatedAt());
        return url;

    }

    private String shortenUrl() {
        StringBuilder shortUrl = new StringBuilder("tiny.lyl");
        shortUrl.append(count.incrementAndGet());
        return shortUrl.toString();
    }

    public long getId() {
        return id;
    }

    public long generateID() {
        return this.id = id;
    }

    public void setShortUrl( String url) {
        shortUrl = url;
    }
    public String getShortUrl() {
        return shortUrl;
    }

    public void setLongUrl( String url) {
        longUrl = url;
    }
    public String getLongUrl() {
        return longUrl;
    }

    public int getHitStats() {
        return hitStats;
    }

    public void updateHitStats() {
        this.hitStats = this.hitStats + 1 ;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "ShortenedUrl{" +
                "id=" + id +
                ", short url='" + shortUrl + '\'' +
                ", hitStats=" + hitStats +
                ", createdAt=" + createdAt +
                '}';
    }
}
