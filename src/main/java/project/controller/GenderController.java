package project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project.model.Gender;
import project.service.GenderService;

import java.io.IOException;


@Controller
@RequestMapping("api/")
public class GenderController {

    private GenderService genderService;

    public GenderController(GenderService genderService) {
        this.genderService = genderService;
    }

    @GetMapping("gender/{name}")
    @ResponseBody
    public Gender checkGenderBasedOnName(@PathVariable("name") String name) throws IOException {
        return genderService.checkGender(name);

    }

//    @GetMapping("gender/full/{name}")
//    @ResponseBody
//    public Gender checkGenderBasedOnFullName(@PathVariable("name") String name){
//        return genderService.checkGenderByFullName(name);
//    }


}