package com.uploader.reposetory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uploader.model.ImageDB;

@Repository
public interface ImageReposetory extends JpaRepository<ImageDB, String> {

}
