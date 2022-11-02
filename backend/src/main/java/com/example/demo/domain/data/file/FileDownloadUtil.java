package com.example.demo.domain.data.file;

import lombok.*;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import javax.persistence.Entity;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author anton
 * @since 11/1/2022, Tue
 **/

@NoArgsConstructor
public class FileDownloadUtil {
    private Path foundFile;

    public Resource getFileAsResource(String fileCode) throws IOException {
        Path dirPath = Paths.get("Files-Upload");

        Files.list(dirPath).forEach(file -> {
            if (file.getFileName().toString().equals(fileCode)) {
                foundFile = file;
                return;
            }
        });

        if (foundFile == null) return null;

        return new UrlResource(foundFile.toUri());
    }
}
