package com.javaa.back.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.javaa.back.dto.ProjectDto;
import com.javaa.back.entity.Product;
import com.javaa.back.entity.ProductProjectCategory;
import com.javaa.back.entity.Professional;
import com.javaa.back.entity.Project;
import com.javaa.back.entity.ProjectCategory;
import com.javaa.back.entity.ProjectImages;
import com.javaa.back.entity.User;
import com.javaa.back.repository.ProductProjectCategoryRepository;
import com.javaa.back.repository.ProductRepository;
import com.javaa.back.repository.ProfessionalRepository;
import com.javaa.back.repository.ProjectCategoryRepository;
import com.javaa.back.repository.ProjectImagesRepository;
import com.javaa.back.repository.ProjectRepository;
import com.javaa.back.repository.UserRepository;

@Service
public class ProjectService {

	@Autowired
	ProjectRepository projectRepository;

	@Autowired
	FileService fileService;

	@Autowired
	UserRepository userRepository;

	@Autowired
	ProjectImagesRepository projectImagesRepository;

	@Autowired
	ProfessionalRepository professionalRepository;

	@Autowired
	ProjectCategoryRepository projectCategoryRepository;

	@Autowired
	ProductProjectCategoryRepository productProjectCategoryRepository;

	@Autowired
	ProductRepository productRepository;

	public List<Project> findAll() {
		return projectRepository.findAll();
	}

	public Project findOne(Long id) {
		Optional<Project> optProject = projectRepository.findById(id);
		if (optProject.isPresent()) {
			return optProject.get();
		} else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}

	public Project save(ProjectDto projectDto, MultipartFile files[]) throws IllegalStateException, IOException {
		Optional<User> optUser = userRepository.findById(projectDto.getUserId());
		if (optUser.isPresent()) {
			Project project = new Project();
			User user = optUser.get();
			project.setCreatedAt(new Date());
			project.setUser(user);
			List<Professional> professionals = new ArrayList<>();
			for (Long id : projectDto.getProfessionalsId()) {
				Optional<Professional> optProfessional = professionalRepository.findById(id);
				if (optProfessional.isPresent()) {
					Professional professional = optProfessional.get();
					professionals.add(professional);
				} else
					throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no pro");

			}
			project.setProfessionals(professionals);
			Optional<ProjectCategory> optProjectCategory = projectCategoryRepository
					.findById(projectDto.getCategoryId());
			if (optProjectCategory.isPresent()) {
				ProjectCategory projectCategory = optProjectCategory.get();
				project.setProjectCategory(projectCategory);
				Project newProject = projectRepository.save(project);
				for (MultipartFile file : files) {
					String image = fileService.uploadFile(file);
					ProjectImages projectImages = new ProjectImages();
					projectImages.setName(image);
					projectImages.setProject(newProject);
					projectImagesRepository.save(projectImages);
				}
				Double budget = 0.0;
				for (Long id : projectDto.getProductsId()) {
					Optional<Product> optProduct = productRepository.findById(id);
					if (optProduct.isPresent()) {
						Product product = optProduct.get();
						ProductProjectCategory productProjectCategory = new ProductProjectCategory();
						productProjectCategory.setProduct(product);
						productProjectCategory.setIsMustHave(projectDto.getIsMustHave());
						productProjectCategory.setProject(newProject);
						budget += product.getPrice();
						productProjectCategoryRepository.save(productProjectCategory);
					} else
						throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no pro");
				}
				Optional<Project> optProjectToUpdateBudget = projectRepository.findById(newProject.getId());
				if (optProjectToUpdateBudget.isPresent()) {
					Project projectToUpdateBudget = optProjectToUpdateBudget.get();
					projectToUpdateBudget.setBudget(budget);
					projectRepository.save(projectToUpdateBudget);
					return projectToUpdateBudget;
				} else
					throw new ResponseStatusException(HttpStatus.NOT_FOUND, "not such project");
			} else
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no category");

		} else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no user");

	}

}
