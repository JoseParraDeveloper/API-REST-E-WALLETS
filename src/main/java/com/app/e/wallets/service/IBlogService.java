package com.app.e.wallets.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.app.e.wallets.dto.BlogDto;
import com.app.e.wallets.exceptions.BadRequestException;
import com.app.e.wallets.exceptions.ResourceNotFoundException;

public interface IBlogService {

	public List<BlogDto> listAllBlog();

	public Page<BlogDto> pageBlog(Pageable pageable);

	public BlogDto getBlogById(Long idBlog) throws ResourceNotFoundException;

	public BlogDto createBlog(BlogDto blogDto);

	public BlogDto updateBlog(BlogDto blogDto) throws ResourceNotFoundException, BadRequestException;

	public void deleteBlogById(Long idBlog) throws ResourceNotFoundException;

}
