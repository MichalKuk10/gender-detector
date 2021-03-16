package project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project.model.Gender;
import project.service.GenderService;

import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("api/")
public class GenderController {

    private GenderService genderService;

    public GenderController(GenderService genderService) {
        this.genderService = genderService;
    }

    @GetMapping("genders/{name}}")
    @ResponseBody
    public Gender checkGenderBasedOnName(@PathVariable("name") String name) throws IOException {
        return genderService.checkGender(name);

    }

    @GetMapping("genders")
    @ResponseBody
    public List<List<String>> checkGenderBasedOnFullName(){
        return genderService.fetchAllTokens();
    }


}