package project.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import project.AppTestsConfig;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppTestsConfig.class})
class GenderControllerTest {

    @Autowired
    private WebApplicationContext webAppContext;
    private MockMvc mockMvc;
    private GenderController controller;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
    }

    @Test
    public void should_return_status_200_when_appropriate_name_passed() throws Exception {
        mockMvc.perform(get("/api/genders/check?variant=firstName&name=Jakub"))
                .andExpect(status().isOk());
    }

    @Test
    public void should_return_status_400_when_wrong_path_passed() throws Exception {
        mockMvc.perform(get("/api/genders/check?varifffant=ffiffrstName&name=Jabbjbj"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void should_return_inconclusive_when_name_not_recognised() throws Exception {
        this.mockMvc.perform(get("/api/genders/check?variant=firstName&name=Jakgtvt"))
                .andExpect(content().string(containsString("INCONCLUSIVE")));
    }


    @Test
    public void should_check_if_retured_list_of_name_contain_female_name() throws Exception {
        this.mockMvc.perform(get("/api/genders/tokens"))
                .andExpect(content().string(containsString("Ada")));
    }
    @Test
    public void should_check_if_retured_list_of_name_contain_male_name() throws Exception {
        this.mockMvc.perform(get("/api/genders/tokens"))
                .andExpect(content().string(containsString("Jakub")));
    }

    @Test
    public void should_return_correct_gender_when_male_provided() throws Exception {
        this.mockMvc.perform(get("/api/genders/check?variant=firstName&name=Jakub"))
                .andExpect(content().string(containsString("MALE")));
    }


    @Test
    public void should_return_correct_gender_when_female_provided() throws Exception {
        this.mockMvc.perform(get("/api/genders/check?variant=firstName&name=Maria"))
                .andExpect(content().string(containsString("FEMALE")));
    }


}