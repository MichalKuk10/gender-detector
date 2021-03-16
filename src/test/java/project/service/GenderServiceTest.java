package project.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import project.dao.GenderTextImplDAO;
import project.model.Gender;

import java.io.IOException;

import static org.mockito.Mockito.when;

class GenderServiceTest {
    @InjectMocks
    GenderService genderService;

    @Mock
    GenderTextImplDAO genderDAO;

    @BeforeEach
    public void init() throws IOException {
        MockitoAnnotations.initMocks(this);

    }


    @Test
    public void should_check_if_appropriate_gender_is_returned_when_name_provided(){
        //given
        String name = "Maciej";
        String variant = "firstName";

        //when
        when(genderDAO.checkIfTokenExists("male", name)).thenReturn(prepareFakeData());

        //then
        Assertions.assertEquals(Gender.MALE, genderService.checkGender(variant, name));

    }

    @Test
    public void should_return_inconclusive_when_wrong_name_provided(){
        //given
        String wrongName = "gdsfsf";
        String variant = "firstName";

        //then
        Assertions.assertEquals(Gender.INCONCLUSIVE, genderService.checkGender(variant, wrongName));
    }


    private boolean prepareFakeData(){
        return true;
    }



}