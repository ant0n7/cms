package com.example.demo.domain.data.file;

import lombok.*;

/**
 * @author anton
 * @since 11/1/2022, Tue
 **/

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class FileUploadResponse {
    private String fileName;
    private String downloadUri;
    private long size;
}
