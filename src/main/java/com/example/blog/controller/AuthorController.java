package com.example.blog.controller;

import com.example.blog.dto.AuthorDto;
import com.example.blog.dto.request.AuthorSaveRequest;
import com.example.blog.model.Author;
import com.example.blog.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/author")
    public ResponseEntity<?> saveAuthor(@RequestBody AuthorSaveRequest authorSaveRequest){
        return new ResponseEntity<>(authorService.saveAuthor(authorSaveRequest), HttpStatus.CREATED);
    }

    @GetMapping("/author-list")
    public ResponseEntity<List<AuthorDto>> listAuthor(){
        return ResponseEntity.ok(authorService.listAuthor());
    }
}
