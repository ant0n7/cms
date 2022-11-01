package com.example.demo.domain.data.employee;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import com.example.demo.domain.data.file.FileDownloadUtil;
import com.example.demo.domain.data.file.FileUploadResponse;
import com.example.demo.domain.data.file.FileUploadUtil;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;


@CrossOrigin
@RestController
@RequestMapping("/api/data/employees")
@RequiredArgsConstructor
public class EmployeeController {
  private final EmployeeService employeeService;

  // Test ResponseEntity endpoint
  @GetMapping("/test")
  public ResponseEntity<String> test() {
    return new ResponseEntity<>("Success.", HttpStatus.OK);
  }
  
  @GetMapping({"/", ""})
  public ResponseEntity<List<Employee>> findAll() {
    return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
  }

  @PostMapping("/{id}/image")
  public ResponseEntity<?> imageUpload(
          @PathVariable("id") UUID employeeId,
          @RequestParam("file")MultipartFile file
  ) throws IOException, NullPointerException {
    String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
    long size = file.getSize();

    String filecode = FileUploadUtil.saveFile(fileName, file);

    FileUploadResponse.FileUploadResponseBuilder responseBuilder = FileUploadResponse.builder()
            .fileName(fileName)
            .size(size)
            .downloadUri("/api/data/employees/images/" + filecode);

    return new ResponseEntity<>(responseBuilder.build(), HttpStatus.OK);
  }

  @GetMapping("/images/{fileCode}")
  public ResponseEntity<?> downloadFileByFileCode(
          @PathVariable("fileCode") String fileCode
  ) {
    FileDownloadUtil downloadUtil = new FileDownloadUtil();

    Resource resource = null;
    try {
      resource = downloadUtil.getFileAsResource(fileCode);
    } catch (IOException e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    if (resource == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    MediaType contentType = MediaType.APPLICATION_OCTET_STREAM;
    String headerValue = "attachment; filename=\"" + resource.getFilename() + "\"";

    return ResponseEntity.ok()
            .contentType(MediaType.APPLICATION_OCTET_STREAM)
            .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
            .body(resource);
  }
}
