package com.example.blog.controller;

import com.example.blog.dto.BlogDto;
import com.example.blog.dto.request.BlogSaveRequest;
import com.example.blog.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/blogs")
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/blog")
    public ResponseEntity<BlogDto> saveBlog(@RequestBody BlogSaveRequest blogSaveRequest){
        return new ResponseEntity<>(blogService.saveBlog(blogSaveRequest), HttpStatus.CREATED);
    }

    @GetMapping("/blog-list")
    public ResponseEntity<?> getAllBlog(){
        return ResponseEntity.ok(this.blogService.getAllBlog());
    }
}
