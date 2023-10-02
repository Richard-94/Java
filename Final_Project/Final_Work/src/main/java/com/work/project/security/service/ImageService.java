package com.work.project.security.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;

import com.work.project.security.model.ImageMetadata;
import com.work.project.security.model.SportsEvents;
import com.work.project.security.repository.ImageRepository;

@Service
public class ImageService {
    @Autowired
    ImageRepository imgRepo;
    @Autowired
    @Qualifier("images")
    private ObjectProvider<ImageMetadata> imageProvider;

    public ImageMetadata createImage(String fileName, String filePath) {
        
        ImageMetadata imgData = imageProvider.getObject();
        imgData.setFileName(fileName);
        imgData.setFilePath(filePath);

        // Save the ImageMetadata object
        imgRepo.save(imgData);

        return imgData;
    }
}
