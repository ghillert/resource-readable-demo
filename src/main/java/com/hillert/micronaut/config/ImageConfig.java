package com.hillert.micronaut.config;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.context.annotation.Context;
import io.micronaut.core.io.Readable;

import java.util.List;

/**
 * @author Gunnar Hillert
 */
@ConfigurationProperties("images")
@Context
public class ImageConfig {
    private Readable imageFile;
    private List<Readable> otherFiles;

    public Readable getImageFile() {
        return imageFile;
    }

    public List<Readable> getOtherFiles() {
        return otherFiles;
    }

    public void setOtherFiles(List<Readable> otherFiles) {
        this.otherFiles = otherFiles;
    }

    public void setImageFile(Readable imageFile) {
        this.imageFile = imageFile;
    }
}
