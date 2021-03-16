package project.dao;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


@Component
public class GenderTextImplDAO implements GenderDAO {

    public List<String> fetchTokens(File filepath) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath));
            List<String> namesList = new ArrayList<>();

            String name;
            while ((name = bufferedReader.readLine()) != null)
                namesList.add(name);

            return namesList;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

}

