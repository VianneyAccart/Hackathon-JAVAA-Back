package com.javaa.back.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.javaa.back.dto.BlogDto;
import com.javaa.back.dto.ProjectCategoryDto;
import com.javaa.back.entity.Blog;
import com.javaa.back.entity.ProjectCategory;
import com.javaa.back.repository.BlogRepository;
import com.javaa.back.repository.ProjectCategoryRepository;

@Service
public class BlogService {
	
	@Autowired
	BlogRepository blogRepository;
	
	@Autowired
	ProjectCategoryRepository projectCategoryRepository;
	
	@Autowired
	FileService fileService;
	
	//Get All
	public List<Blog> findAll(){
		return blogRepository.findAll();
	}
	
	//Get one
	public Blog getOne(Long id) {
		Optional<Blog> optBlog = blogRepository.findById(id);
		if(optBlog.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return optBlog.get(); 
	}
	
//	//GetByCategoryId 
//	public Long getByCategoryId(BlogDto blogDto,Long id) {
//		Optional<ProjectCategory> optCategory = projectCategoryRepository.findById(blogDto.getProjectCategoryId());
//		if(optCategory.isEmpty()) {
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//		}
//		return optCategory.get();
//	}
	
//Create
	public Blog save(BlogDto blogDto,MultipartFile file) throws IllegalStateException, IOException {
		String image = fileService.uploadFile(file);
		Optional<ProjectCategory> optProjectCategory = projectCategoryRepository.findById(blogDto.getProjectCategoryId());
		if(optProjectCategory.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		Blog blog = new Blog(); 
		blog.setTitle(blogDto.getTitle());
		blog.setDescription(blogDto.getDescription());
		blog.setImage(image);
		blog.setUrl(blogDto.getUrl());
		blog.setProjectCategory(optProjectCategory.get());
		return blogRepository.save(blog);
	}

//Delete
	public void delete(Long id) {
		Optional<Blog> optBlog = blogRepository.findById(id);
		if (optBlog.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		blogRepository.deleteById(id);
	}


	

}
