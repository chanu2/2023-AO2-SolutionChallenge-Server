package gdsc.RunEatServer.domain.image.controller;

import gdsc.RunEatServer.domain.image.dto.UploadImageResponse;
import gdsc.RunEatServer.domain.image.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RequiredArgsConstructor
@RequestMapping("/api/v1/images")
@RestController
public class ImageController {
     private final ImageService imageService;
    @PostMapping("/upload")
    public UploadImageResponse uploadImage(@RequestPart(value = "file") MultipartFile file) {
        return imageService.uploadImage(file);
    }


}