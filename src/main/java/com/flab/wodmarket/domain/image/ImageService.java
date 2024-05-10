package com.flab.wodmarket.domain.image;

import com.flab.wodmarket.domain.image.dto.request.ImageInfo;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
@Slf4j
@RequiredArgsConstructor
public class ImageService {
    private final ImageMapper imageMapper;

    public ImageInfo saveImage(MultipartFile file, Long itemNo) throws IOException {
        String uploadDir = "/uploads/images/";
        String filename = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        String fileExtension = StringUtils.getFilenameExtension(filename);
        String savedFileName = UUID.randomUUID() + "." + fileExtension;
        String storagePath = System.getProperty("user.dir") + uploadDir + savedFileName;

        saveFile(file, storagePath);

        ImageInfo imageInfo = ImageInfo.builder()
                .itemNo(itemNo)
                .imgOrgName(filename)
                .imgName(savedFileName)
                .imgUrl(uploadDir + savedFileName)
                .build();

        imageMapper.save(imageInfo);
        return imageInfo;
    }

    private void saveFile(MultipartFile file, String storagePath) throws IOException {
        Path path = Paths.get(storagePath);
        Files.createDirectories(path.getParent());
        file.transferTo(path);
    }
}