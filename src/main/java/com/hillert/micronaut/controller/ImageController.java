package com.hillert.micronaut.controller;

import com.hillert.micronaut.config.ImageConfig;
import io.micronaut.core.io.Writable;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.server.types.files.StreamedFile;

import javax.inject.Inject;
import java.io.IOException;
import java.util.Random;

@Controller("/images")
public class ImageController {

    @Inject
    ImageConfig imageConfig;

    @Get(uri="/single", processes = "images/jpg")
    StreamedFile getSingleImage() {
        try {
            return new StreamedFile(imageConfig.getImageFile().asInputStream(), MediaType.IMAGE_JPEG_TYPE);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Get(uri="/random", processes = "images/jpg")
    StreamedFile getRandomImage() {
        int imageIndex = this.getRandomNumber(imageConfig.getOtherFiles().size());

        try {
            return new StreamedFile(imageConfig.getOtherFiles().get(imageIndex).asInputStream(), MediaType.IMAGE_JPEG_TYPE);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private int getRandomNumber(int max) {
        final Random random = new Random();
        return random.ints(0, max)
                .findFirst()
                .getAsInt();
    }
}
