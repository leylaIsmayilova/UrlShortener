package com.example.infinaDemo.shortenedUrl;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShortenedUrlRepository
        extends CrudRepository<ShortenedUrl, Long> {
}
//TODO log4j, interfaces, encoding/base64, unique urls