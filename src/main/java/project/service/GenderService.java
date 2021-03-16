package project.service;

import org.springframework.stereotype.Service;
import project.dao.DAO;
import project.model.Gender;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class GenderService {
   private final File filepathFemale = new File("/Users/michal/Desktop/Codecool/Projects/gender-detector/src/main/resources/female.txt");
   private final File filepathMale = new File("/Users/michal/Desktop/Codecool/Projects/gender-detector/src/main/resources/male.txt");


    public DAO dao;

    public GenderService(DAO dao) {
        this.dao = dao;
    }

    public Gender checkGender(String name) throws IOException {

        try {

            if(fetchResult(filepathFemale, name)){
                return Gender.FEMALE;
            }else if(fetchResult(filepathMale, name)){
                return Gender.MALE;
            }else {
                return Gender.INCONCLUSIVE;
            }

        }catch (IOException e){
            e.printStackTrace();
        }

        return null;
    }

    private boolean fetchResult(File filepath, String name) throws IOException {
        List<String> stringList = dao.fetchDataFromFile(filepath);
        for (String element : stringList){
            if (element.equals(name)){
                return true;
            }
        }
        return false;

    }


}
