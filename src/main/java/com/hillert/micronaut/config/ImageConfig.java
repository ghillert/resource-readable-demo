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
package com.hillert.micronaut.config;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.context.annotation.Context;
import io.micronaut.core.io.Readable;

import java.util.List;

/**
 * Holds {@link ConfigurationProperties} for the application.
 *
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
