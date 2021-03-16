package project.service;

import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import project.dao.GenderTextImplDAO;
import project.model.Gender;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GenderService {

    private GenderTextImplDAO dao;
    private final String FEMALE_PATH = "female";
    private final String MALE_PATH = "male";


    public GenderService(GenderTextImplDAO dao) {
        this.dao = dao;
    }

    public Gender checkGender(String name){

        if (checkIfNameExist(FEMALE_PATH, name)) {
            return Gender.FEMALE;
        } else if (checkIfNameExist(MALE_PATH, name)) {
            return Gender.MALE;
        }
        return  Gender.INCONCLUSIVE;

    }

    public Gender checkGenderByFullName(String name) throws IOException {
        String[] split = name.split(" ");
        int femaleCounter = 0;
        int maleCounter = 0;

        for (String element : split) {
            if (checkIfNameExist(FEMALE_PATH, element)) {
                femaleCounter++;
            } else if (checkIfNameExist(MALE_PATH, element)) {
                maleCounter++;
            }
        }

        return estimateGender(femaleCounter, maleCounter);
    }

    public List<List<String>> fetchAllTokens() {
        List<String> femaleList = fetchList(FEMALE_PATH);
        List<String> maleList = fetchList(MALE_PATH);

        List<List<String>> bothGendersList = new ArrayList<>();

        bothGendersList.add(femaleList);
        bothGendersList.add(maleList);

        return bothGendersList;

    }

    private boolean checkIfNameExist(String filepath, String name) {
        List<String> stringList = fetchList(filepath);
        return stringList.stream().anyMatch(element -> element.equals(name));
    }

    private List<String> fetchList(String filepath){
        return dao.fetchTokens(filepath);
    }

    private Gender estimateGender(int femaleCounter, int maleCounter){
        if(femaleCounter > maleCounter){
            return Gender.FEMALE;
        }else if (femaleCounter < maleCounter) {
            return Gender.MALE;
        }

        return Gender.INCONCLUSIVE;
    }

    public Gender callCheckGenderMethod(String variant, String name) throws IOException {
        switch (variant){
            case "firstName":
                return checkGender(name);
            case "fullName":
                checkGenderByFullName(name);
                break;
        }
        return Gender.INCONCLUSIVE;

    }


}
