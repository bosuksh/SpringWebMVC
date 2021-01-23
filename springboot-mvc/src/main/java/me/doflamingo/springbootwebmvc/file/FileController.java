package me.doflamingo.springbootwebmvc.file;

import lombok.RequiredArgsConstructor;
import org.apache.tika.Tika;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class FileController {

  private final ResourceLoader resourceLoader;
  private final Tika tika;

  @GetMapping("/files")
  public String getFileForm(Model model) {
    return "files/index";
  }

  @PostMapping("/files")
  public String uploadFile(@RequestParam MultipartFile file,
                           RedirectAttributes redirectAttributes) {
    System.out.println("file name: "+file.getName());
    System.out.println("file original name: "+file.getOriginalFilename());
    String message = file.getOriginalFilename()+" is uploaded.";
    redirectAttributes.addFlashAttribute("message", message);
    return "redirect:/files";
  }

  @GetMapping("/files/{fileName}")
  public ResponseEntity<?> downloadFile(@PathVariable String fileName) throws IOException {
    Resource resource = resourceLoader.getResource("classpath:"+fileName);
    File file = resource.getFile();
    String mediaType = tika.detect(file);
    return ResponseEntity.ok()
      .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\""+fileName+"\"")
      .header(HttpHeaders.CONTENT_TYPE,mediaType)
      .header(HttpHeaders.CONTENT_LENGTH, file.length()+"")
      .body(resource);
  }
}
