package com.example.blog.dto.connverter;

import com.example.blog.dto.BlogDto;
import com.example.blog.dto.request.BlogSaveRequest;
import com.example.blog.model.Blog;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class BlogDtoConverter {

    public BlogDto convertToBlogDto(Blog from){
        return new BlogDto(
                from.getCreatedTime(),
                from.getLastUpdateTime(),
                from.getContent(),
                Objects.requireNonNull(from.getAuthor())
        );



    }
}
