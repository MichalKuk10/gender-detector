package project.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import project.dao.GenderDAO;
import project.dao.GenderTextImplDAO;
import project.model.Gender;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

class GenderServiceTest {
    @InjectMocks
    GenderService genderService;

    @Mock
    GenderTextImplDAO genderDAO;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        when(genderDAO.fetchTokens("male")).thenReturn(prepareFakeData());
    }


    @Test
    public void should_check_if_appropriate_gender_is_returned_when_name_provided(){
        //given
        String name = "Maciej";

        //then
        Assertions.assertEquals(Gender.MALE, genderService.checkGender(name));

    }

    @Test
    public void should_return_inconclusive_when_wrong_name_provided(){
        //given
        String wrongName = "gdsfsf";

        //then
        Assertions.assertEquals(Gender.INCONCLUSIVE, genderService.checkGender(wrongName));
    }


    private List<String> prepareFakeData(){
        return Arrays.asList("Maciej");
    }

}