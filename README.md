# Demo: Loading Resources in Micronaut using Readable

In this demo I show have you can use [Micronaut's](https://micronaut.io/)
[Readable](https://docs.micronaut.io/latest/api/io/micronaut/core/io/Readable.html)
interface to load resources from either the classpath, or the filesystem in an
implementation agnostic fashion.

## How to Run

```bash
git clone https://github.com/ghillert/resource-readable-demo.git
./cd resource-readable-demo
```

```bash
./mvnw mn:run
```

```bash
./mvnw clean package
java -jar target/resource-readable-demo-0.1.jar --images.image-file=file:/Users/hillert/Desktop/end-of-springone-2020.jpg
```

The following 2 REST API endpoints are available:

- http://localhost:8080/images/single
- http://localhost:8080/images/random

If you like to override the property for the single image `images.image-file` and
load an image from the file-system instead, you can do that e.g. with:

```bash
java -jar target/resource-readable-demo-0.1.jar --images.image-file=file:/my/path/to/some/awesome-image.jpg
```

or

```bash
./mvnw mn:run -Dmn.appArgs="--images.image-file=file:/my/path/to/some/awesome-image.jpg"
```

## Configuration File

The main configuration of the demo is in `application.yml`:

```yaml
micronaut:
  application:
    name: Micronaut Readable Demo
images:
  image-file: "classpath:images/bismarckia-nobilis.jpg"
  # image-file: "file:/path/to/images/bismarckia-nobilis.jpg"
  other-files:
    - "classpath:images/bismarckia-nobilis.jpg"
    - "classpath:images/bamboo.jpg"
    - "classpath:images/hibiscus.jpg"
```