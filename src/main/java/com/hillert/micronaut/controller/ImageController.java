/*
 * Copyright 2020 Gunnar Hillert
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hillert.micronaut.controller;

import com.hillert.micronaut.config.ImageConfig;
import io.micronaut.core.io.Readable;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.server.types.files.StreamedFile;

import javax.inject.Inject;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Random;

/**
 * Provides 2 simple REST enpoints:
 *
 * <ul>
 *   <li>{@code /images/single}
 *   <li>{@code /images/random}
 * </ul>
 *
 * @author Gunnar Hillert
 */
@Controller("/images")
public class ImageController {

	@Inject
	ImageConfig imageConfig;

	@Get(uri="/single", processes = "images/jpg")
	public StreamedFile getSingleImage() {
		final Readable singleImage = imageConfig.getImageFile();
		try {
			final InputStream is = singleImage.asInputStream();
			return new StreamedFile(is, MediaType.IMAGE_JPEG_TYPE);
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}

	@Get(uri="/random", processes = "images/jpg")
	public StreamedFile getRandomImage() {
		int imageIndex = this.getRandomNumber(imageConfig.getOtherFiles().size());
		final Readable randomImage = imageConfig.getOtherFiles().get(imageIndex);
		try {
			final InputStream is = randomImage.asInputStream();
			return new StreamedFile(is, MediaType.IMAGE_JPEG_TYPE);
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
