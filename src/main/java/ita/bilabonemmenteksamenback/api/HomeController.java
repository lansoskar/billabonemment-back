package ita.bilabonemmenteksamenback.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    @ResponseBody
    public String hello() {
        return "Hello, on root use /api/ when making calls fx /api/cars !";
    }
}

