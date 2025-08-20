package com.example.file_storage.repository;

import com.example.file_storage.model.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, String> {
}