package com.flab.wodmarket.domain.image;

import com.flab.wodmarket.domain.image.dto.request.ImageInfo;
import jakarta.validation.Valid;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;


@RequiredArgsConstructor
@RestController
@Slf4j
public class ImageController {

    private final ImageService imageService;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ImageInfo> uploadImage(@RequestPart("file") MultipartFile file,
                                                 @RequestParam("itemNo") Long itemNo) {
        try {
            ImageInfo savedImage = imageService.saveImage(file, itemNo);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedImage);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "파일 업로드 실패", e);
        }
    }


    @PostMapping(value = "/img", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> save(@Valid @RequestParam("file") MultipartFile file) {
        String directory = System.getProperty("user.dir") + "/src/main/uploads/static/img/";
        String filename = file.getOriginalFilename();

        try {
            File destination = new File(directory + filename);
            file.transferTo(destination);
            return ResponseEntity.status(HttpStatus.CREATED).body("파일이 업로드된 위치: " + directory + filename);
        } catch (IOException e) {
            log.error("파일 업로드 실패", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("파일 업로드 실패: " + e.getMessage());
        }
    }

    @GetMapping(value = "/img/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable String imageName) throws IOException {
        String filePath = "./uploads/images/" + imageName;
        try (InputStream in = new FileInputStream(filePath)) {
            byte[] imageBytes = in.readAllBytes();
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
        } catch (FileNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
