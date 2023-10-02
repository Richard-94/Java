package com.work.project.security.repository;

import org.springframework.data.repository.CrudRepository;

import com.work.project.security.model.ImageMetadata;

public interface ImageRepository extends CrudRepository<ImageMetadata, Long> {

}
