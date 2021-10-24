package com.example.blog.repository;

import com.example.blog.model.Blog;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface BlogRepository extends JpaRepository<Blog , UUID> {

}
