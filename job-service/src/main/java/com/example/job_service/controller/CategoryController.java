package com.example.job_service.controller;


import com.example.job_service.dto.CategoryDto;
import com.example.job_service.dto.JobDto;
import com.example.job_service.requests.catagory.CategoryCreateRequest;
import com.example.job_service.requests.catagory.CategoryUpdateRequest;
import com.example.job_service.services.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/v1/job-service/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<CategoryDto> createCategory(@Valid @RequestPart CategoryCreateRequest request,
                                               @RequestPart(required = false) MultipartFile file) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(modelMapper.map(categoryService.createCategory(request,file), CategoryDto.class));
    }

    @GetMapping("/getAll")
    ResponseEntity<List<CategoryDto>> getAll() {
        return ResponseEntity.ok(categoryService.getAll().stream()
                .map(category -> modelMapper.map(category, CategoryDto.class)).toList());
    }

    @GetMapping("/getCategoryById/{id}")
    ResponseEntity<CategoryDto> getCategoryById(@PathVariable String id) {
        return ResponseEntity.ok(modelMapper.map(categoryService.getCategoryById(id), CategoryDto.class));
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<JobDto> updateCategoryById(@Valid @RequestPart CategoryUpdateRequest request,
                                              @RequestPart(required = false) MultipartFile file) {
        return ResponseEntity.ok(modelMapper.map(categoryService.updateCategoryById(request,file), JobDto.class));
    }

    @DeleteMapping("/deleteCategoryById/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<Void> deleteCategoryById(@PathVariable String id) {
        categoryService.deleteCategoryById(id);
        return ResponseEntity.ok().build();
    }
}