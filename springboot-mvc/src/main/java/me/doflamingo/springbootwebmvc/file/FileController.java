package me.doflamingo.springbootwebmvc.file;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FileController {

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
}
