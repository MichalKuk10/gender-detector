package project;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import project.controller.GenderController;
import project.dao.GenderTextImplDAO;
import project.service.GenderService;


@EnableWebMvc
@Configuration
public class AppTestsConfig {

    @Bean
    public GenderTextImplDAO genderTextImplDAO() {
        return new GenderTextImplDAO();
    }

    @Bean
    public GenderService genderService() {
        return new GenderService(genderTextImplDAO());
    }

    @Bean
    GenderController genderController(){return  new GenderController(genderService());}

}
