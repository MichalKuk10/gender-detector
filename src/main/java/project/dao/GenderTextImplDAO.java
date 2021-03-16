package project.dao;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


@Component
public class GenderTextImplDAO implements GenderDAO {
    private final File FILE_PATH_FEMALE = new File("/Users/michal/Desktop/Codecool/Projects/gender-detector/src/main/resources/female.txt");
    private final File FILE_PATH_MALE = new File("/Users/michal/Desktop/Codecool/Projects/gender-detector/src/main/resources/male.txt");


    public List<String> fetchTokens(String filepath) {

        try {
            BufferedReader bufferedReader;
            if(filepath.equals("female")) {
                 bufferedReader = new BufferedReader(new FileReader(FILE_PATH_FEMALE));
            }
            else{
                 bufferedReader = new BufferedReader(new FileReader(FILE_PATH_MALE));

            }
            List<String> namesList = new ArrayList<>();

            String name;
            while ((name = bufferedReader.readLine()) != null)
                namesList.add(name);

            return namesList;
        } catch (IOException e) {
            e.printStackTrace();

        }
        return  null;
    }

}

