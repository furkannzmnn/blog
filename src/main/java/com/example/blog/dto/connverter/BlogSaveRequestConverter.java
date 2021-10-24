package com.example.blog.dto.connverter;

import com.example.blog.dto.request.BlogSaveRequest;
import com.example.blog.model.Blog;
import org.springframework.stereotype.Component;

@Component
public class BlogSaveRequestConverter {

    public Blog blogSaveRequestToBlog(BlogSaveRequest blogSaveRequest){
        return new Blog(
               blogSaveRequest.getContent(),
                blogSaveRequest.getAuthor()
        );
    }
}
