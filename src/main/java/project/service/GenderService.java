package project.service;

import org.springframework.stereotype.Service;
import project.dao.GenderTextImplDAO;
import project.model.Gender;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GenderService {
    private final File filepathFemale = new File("/Users/michal/Desktop/Codecool/Projects/gender-detector/src/main/resources/female.txt");
    private final File filepathMale = new File("/Users/michal/Desktop/Codecool/Projects/gender-detector/src/main/resources/male.txt");
    private GenderTextImplDAO dao;

    public GenderService(GenderTextImplDAO dao) {
        this.dao = dao;
    }

    public Gender checkGender(String name) throws IOException {

        try {
            if (checkIfNameExist(filepathFemale, name)) {
                return Gender.FEMALE;
            } else if (checkIfNameExist(filepathMale, name)) {
                return Gender.MALE;
            }
            return  Gender.INCONCLUSIVE;
        } catch (IOException e) {
            e.printStackTrace();
        }

      return Gender.INCONCLUSIVE;
    }

    public Gender checkGenderByFullName(String name) throws IOException {
        String[] split = name.split(" ");
        int femaleCounter = 0;
        int maleCounter = 0;

        for (String element : split) {
            if (checkIfNameExist(filepathFemale, element)) {
                femaleCounter++;
            } else if (checkIfNameExist(filepathMale, element)) {
                maleCounter++;
            }
        }

        return estimateGender(femaleCounter, maleCounter);
    }

    public List<List<String>> fetchAllTokens() {
        List<String> femaleList = fetchList(filepathFemale);
        List<String> maleList = fetchList(filepathMale);

        List<List<String>> bothGendersList = new ArrayList<>();

        bothGendersList.add(femaleList);
        bothGendersList.add(maleList);

        return bothGendersList;

    }

    private boolean checkIfNameExist(File filepath, String name) throws IOException {
        List<String> stringList = fetchList(filepath);
        return stringList.stream().anyMatch(element -> element.equals(name));
    }

    private List<String> fetchList(File filepath) {
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


}
