package com.example.blog.dto.connverter;

import com.example.blog.dto.request.AuthorSaveRequest;
import com.example.blog.model.Author;
import com.example.blog.model.Blog;
import com.example.blog.model.SocialMedia;
import org.springframework.data.auditing.AuditingHandler;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class AuthorSaveRequestConverter {
    public Author authorSaveRequestToAuthor(AuthorSaveRequest authorSaveRequest){

        return new Author(
                authorSaveRequest.getFullName(),
                authorSaveRequest.getAge(),
                authorSaveRequest.getImageUrl(),
                authorSaveRequest.getSocialMedia(),
                authorSaveRequest.getSex()
        );
    }
}
