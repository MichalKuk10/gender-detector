package project.dao;

import org.springframework.stereotype.Component;

import java.io.*;


@Component
public class GenderTextImplDAO implements GenderDAO {
    private final File FILE_PATH_FEMALE = new File("/Users/michal/Desktop/Codecool/Projects/gender-detector/src/main/resources/female.txt");
    private final File FILE_PATH_MALE = new File("/Users/michal/Desktop/Codecool/Projects/gender-detector/src/main/resources/male.txt");

    @Override
    public boolean fetchTokensByName(String filepath, String name) {

        try {
            BufferedReader bufferedReader;
            if (filepath.equals("female")) {
                bufferedReader = new BufferedReader(new FileReader(FILE_PATH_FEMALE));
            } else {
                bufferedReader = new BufferedReader(new FileReader(FILE_PATH_MALE));

            }
            String next;
            while ((next = bufferedReader.readLine()) != null) {
                if (next.equals(name)) {
                    return true;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();

        }
        return false;
    }

    public String fetchFemaleNamesFromDatabase() throws IOException {
        return fetchAllNamesFromDatabase(FILE_PATH_FEMALE);
    }

    public String fetchMaleNamesFromDatabase() throws IOException {
        return fetchAllNamesFromDatabase(FILE_PATH_MALE);
    }


    public String fetchAllNamesFromDatabase(File filepath) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath));
        String element;
        StringBuilder names = new StringBuilder();
        while ((element = bufferedReader.readLine()) != null) {
            names.append(element).append(" ");
        }

        return names.toString();
    }
}



