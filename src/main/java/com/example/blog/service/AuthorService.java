package com.example.blog.service;

import com.example.blog.dto.AuthorDto;
import com.example.blog.dto.connverter.AuthorDtoConverter;
import com.example.blog.dto.connverter.AuthorSaveRequestConverter;
import com.example.blog.dto.request.AuthorSaveRequest;
import com.example.blog.model.Author;
import com.example.blog.model.SocialMedia;
import com.example.blog.repository.AuthorRepository;
import com.example.blog.repository.SocialMediaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorSaveRequestConverter authorSaveRequestConverter;
    private final AuthorDtoConverter authorDtoConverter;
    private final SocialMediaRepository socialMediaRepository;

    public AuthorService(AuthorRepository authorRepository, AuthorSaveRequestConverter authorSaveRequestConverter, AuthorDtoConverter authorDtoConverter, SocialMediaRepository socialMediaRepository) {
        this.authorRepository = authorRepository;
        this.authorSaveRequestConverter = authorSaveRequestConverter;
        this.authorDtoConverter = authorDtoConverter;
        this.socialMediaRepository = socialMediaRepository;
    }

    public AuthorDto saveAuthor(AuthorSaveRequest authorSaveRequest){

        Author author = authorSaveRequestConverter.authorSaveRequestToAuthor(authorSaveRequest);

        return authorDtoConverter.convertToAuthorDto(
                authorRepository.save(author)
        );

    }

    public List<AuthorDto> listAuthor(){
        return authorRepository.findAll()
                .stream()
                .map(authorDtoConverter::convertToAuthorDto)
                .collect(Collectors.toList());
    }


}
