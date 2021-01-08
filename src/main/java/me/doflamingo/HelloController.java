package me.doflamingo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    @ResponseBody
    public String getName() {
        return "Hello "+helloService.getName();
    }

    @GetMapping("/sample")
    public String sample() {
        return "sample";
    }
}
