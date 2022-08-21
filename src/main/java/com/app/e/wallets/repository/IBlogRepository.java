package com.app.e.wallets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.e.wallets.entities.Blog;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Long> {

}
