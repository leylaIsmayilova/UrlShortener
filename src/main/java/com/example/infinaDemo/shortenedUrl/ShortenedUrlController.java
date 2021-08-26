package com.example.infinaDemo.shortenedUrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Configurable
public class ShortenedUrlController {

    @Autowired
    private ShortenedUrlService shortenedUrlService;

    @Autowired

    public ShortenedUrlController(){}

    @RequestMapping(value ="api/v1/urlShortener", method = RequestMethod.POST)
    public ResponseEntity<ShortenedUrlDto>  registerUrl(@RequestBody final String urlToShorten){
        ShortenedUrl newUrl = shortenedUrlService.registerUrl(urlToShorten);
        ShortenedUrlDto urlDto = new ShortenedUrlDto().from(newUrl);
        return new ResponseEntity<>(urlDto, HttpStatus.OK);

    }
/*
    @GetMapping(path = "api/v1/urlShortenerGet")
    public ResponseEntity<List<ShortenedUrlDto>> getUrls() {

        List<ShortenedUrl> urls = shortenedUrlService.getUrls();
        List<ShortenedUrlDto> urlDtoList = urls.stream().map(ShortenedUrlDto::from).collect(Collectors.toList());
        ResponseEntity<List<ShortenedUrlDto>> tResponseEntity = new ResponseEntity<>(urlDtoList, HttpStatus.OK);
        return tResponseEntity;
    }


    public ResponseEntity<ShortenedUrlDto> getUrl( @PathVariable final Long id){
        ShortenedUrl url = shortenedUrlService.getUrlById(id);
        return new ResponseEntity<>(ShortenedUrlDto.from(url), HttpStatus.OK);
    }
    
    public ResponseEntity<ShortenedUrlDto> getUrl( @PathVariable final String shortUrl){
        ShortenedUrl url = shortenedUrlService.getUrlByShort(shortUrl);
        return new ResponseEntity<>(ShortenedUrlDto.from(url), HttpStatus.OK);
    }

    @PutMapping( value = "{id}", path = "api/v1/urlShortenerPut")
    public ResponseEntity<ShortenedUrlDto> editUrl( @PathVariable final Long id,
                                                    @RequestBody final ShortenedUrlDto urlDto){
        ShortenedUrl toEdit = shortenedUrlService.editUrl( id, ShortenedUrl.from(urlDto) );
        return new ResponseEntity<>(ShortenedUrlDto.from(toEdit), HttpStatus.OK);
    }

*/



}
