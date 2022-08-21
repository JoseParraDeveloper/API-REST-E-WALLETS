package com.app.e.wallets.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.e.wallets.dto.BlogDto;
import com.app.e.wallets.entities.Blog;
import com.app.e.wallets.exceptions.BadRequestException;
import com.app.e.wallets.exceptions.ResourceNotFoundException;
import com.app.e.wallets.repository.IBlogRepository;

@Service
public class BlogServiceImpl implements IBlogService {
	@Autowired
	private IBlogRepository blogRepository;
	@Autowired
	@Qualifier("modelMapper")
	private ModelMapper modelMapper;

	@Override
	public List<BlogDto> listAllBlog() {
		List<Blog> listBlog = blogRepository.findAll();
		return listBlog.stream().map(blog -> modelMapper.map(blog, BlogDto.class)).collect(Collectors.toList());
	}

	@Override
	public Page<BlogDto> pageBlog(Pageable pageable) {
		Page<Blog> pageBlogs = blogRepository.findAll(pageable);
		List<BlogDto> listBlogDto = pageBlogs.stream().map(pageBlog -> modelMapper.map(pageBlog, BlogDto.class))
				.collect(Collectors.toList());
		return new PageImpl<>(listBlogDto);
	}

	@Override
	public BlogDto getBlogById(Long idBlog) throws ResourceNotFoundException {
		Optional<Blog> optionalBlog = blogRepository.findById(idBlog);
		return modelMapper.map(
				optionalBlog.orElseThrow(
						() -> new ResourceNotFoundException(Blog.class.getName(), "id", idBlog.toString())),
				BlogDto.class);
	}

	@Override
	public BlogDto createBlog(BlogDto blogDto) {
		blogDto.setCreationTimestamp(new Date());
		blogDto.setCreationTimestamp(new Date());
		Blog newBlog = modelMapper.map(blogDto, Blog.class);
		newBlog = blogRepository.save(newBlog);
		return modelMapper.map(newBlog, BlogDto.class);
	}

	@Override
	public BlogDto updateBlog(BlogDto updateBlogDto) throws ResourceNotFoundException, BadRequestException {
		Long idBlog = updateBlogDto.getId();
		if (idBlog != null) {
			Optional<Blog> optionalBlog = blogRepository.findById(idBlog);
			if (!optionalBlog.isPresent()) {
				throw new ResourceNotFoundException(Blog.class.getName(), "id", idBlog.toString());
			}
		} else {
			throw new BadRequestException("Bad Request");
		}
		return this.createBlog(updateBlogDto);
	}

	@Override
	public void deleteBlogById(Long idBlog) throws ResourceNotFoundException {
		Optional<Blog> optionalBlog = blogRepository.findById(idBlog);
		optionalBlog.ifPresentOrElse(deleteBlog -> blogRepository.delete(deleteBlog), () -> {
			throw new ResourceNotFoundException(Blog.class.getName(), "id", idBlog.toString());
		});

	}

}
