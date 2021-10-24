package com.example.blog.controller;

import com.example.blog.model.SocialMedia;
import com.example.blog.repository.SocialMediaRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/social")
public class SocialMediaController {

    private final SocialMediaRepository socialMediaRepository;

    public SocialMediaController(SocialMediaRepository socialMediaRepository) {
        this.socialMediaRepository = socialMediaRepository;
    }

    @PostMapping("/add")
    public SocialMedia add(@RequestBody SocialMedia socialMedia){
        return this.socialMediaRepository.save(socialMedia);
    }
}
