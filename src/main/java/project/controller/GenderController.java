package project.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project.model.Gender;
import project.service.GenderService;

import java.io.IOException;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;


@Controller
@RequestMapping("api/genders")
public class GenderController {

    private GenderService genderService;

    public GenderController(GenderService genderService) {
        this.genderService = genderService;
    }


    @GetMapping("/check")
    @ResponseBody
    @ResponseStatus(OK)
    public Gender checkGenderBasedOnName(@RequestParam(value="variant") String variant, @RequestParam(value="name") String name) throws IOException {
        if(variant.equals("firstName")) {
            return genderService.checkGender(name);
        }else{
             return genderService.checkGenderByFullName(name);
        }
    }

    @GetMapping
    @ResponseBody
    @ResponseStatus(OK)
    public List<List<String>> returnAllNames(){
        return genderService.fetchAllTokens();
    }


}