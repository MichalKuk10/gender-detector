package project.service;

import org.springframework.stereotype.Service;
import project.dao.GenderDAO;
import project.model.Gender;


@Service
public class GenderService {
    private GenderDAO dao;
    private final String FEMALE_PATH = "female";
    private final String MALE_PATH = "male";


    public GenderService(GenderDAO dao) {

        this.dao = dao;
    }

    public Gender checkGenderByFirstName(String name) {

        if (checkIfNameExist(FEMALE_PATH, name)) return Gender.FEMALE;
        else if (checkIfNameExist(MALE_PATH, name)) return Gender.MALE;

        return Gender.INCONCLUSIVE;

    }

    public Gender checkGenderByFullName(String name) {
        String[] split = name.split(" ");
        int femaleCounter = 0;
        int maleCounter = 0;

        for (String element : split) {
            if (checkIfNameExist(FEMALE_PATH, element)) femaleCounter++;
            else if (checkIfNameExist(MALE_PATH, element)) maleCounter++;

        }

        return estimateGender(femaleCounter, maleCounter);
    }


    public String fetchAllNames() {
        String femaleNames = dao.fetchFemaleNamesFromDatabase();
        String maleNames = dao.fetchMaleNamesFromDatabase();

        return femaleNames + maleNames;
    }

    public Gender checkGender(String variant, String name) {
        if (variant.equals("firstName")) return checkGenderByFirstName(name);
        else if (variant.equals("fullName")) return checkGenderByFullName(name);
        return Gender.INCONCLUSIVE;

    }


    private boolean checkIfNameExist(String filepath, String name) {
        return dao.checkIfTokenExists(filepath, name);
    }

    private Gender estimateGender(int femaleCounter, int maleCounter) {
        if (femaleCounter > maleCounter) return Gender.FEMALE;
        else if (femaleCounter < maleCounter) return Gender.MALE;
        else return Gender.INCONCLUSIVE;
    }

}
