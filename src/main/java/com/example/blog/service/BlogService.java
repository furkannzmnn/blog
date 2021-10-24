package com.example.blog.service;

import com.example.blog.dto.BlogDto;
import com.example.blog.dto.connverter.BlogDtoConverter;
import com.example.blog.dto.connverter.BlogSaveRequestConverter;
import com.example.blog.dto.request.BlogSaveRequest;
import com.example.blog.model.Blog;
import com.example.blog.repository.BlogRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService {

    private final BlogRepository blogRepository;
    private final BlogDtoConverter blogDtoConverter;
    private final BlogSaveRequestConverter blogSaveRequestConverter;

    public BlogService(BlogRepository blogRepository, BlogDtoConverter blogDtoConverter, BlogSaveRequestConverter blogSaveRequestConverter) {
        this.blogRepository = blogRepository;
        this.blogDtoConverter = blogDtoConverter;
        this.blogSaveRequestConverter = blogSaveRequestConverter;
    }


    public BlogDto saveBlog(BlogSaveRequest blogSaveRequest){

       Blog blog =  blogSaveRequestConverter.blogSaveRequestToBlog(blogSaveRequest);

       return blogDtoConverter.convertToBlogDto(blogRepository.save(blog));
    }

    public List<BlogDto> getAllBlog(){
        return blogRepository.findAll()
                .stream()
                .map(blogDtoConverter::convertToBlogDto)
                .collect(Collectors.toList());
    }
}
