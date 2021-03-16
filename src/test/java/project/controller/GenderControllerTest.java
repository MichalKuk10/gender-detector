package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class GenderControllerTest {

    @Autowired
    private WebApplicationContext webAppContext;
    private MockMvc mockMvc;

    public void when_correct_input_then_return_200() throws Exception {
        mockMvc.perform(get("/api/gender/first/Adela"))
                .andExpect(status().isOk());
    }

}