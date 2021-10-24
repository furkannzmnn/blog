package com.example.blog.dto.connverter;

import com.example.blog.dto.AuthorDto;
import com.example.blog.dto.request.AuthorSaveRequest;
import com.example.blog.model.Author;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Set;

@Component
public class AuthorDtoConverter {

    public AuthorDto convertToAuthorDto(Author from){
        return new AuthorDto(
               from.getFullName(),
                from.getAge(),
                from.getImageUrl(),
                Objects.requireNonNull(from.getSocialMedia()),
                from.getSex(),
                from.getBlog()
        );
    }


}
