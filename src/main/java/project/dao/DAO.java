package project.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class DAO  {

        public  List<String> fetchFemaleData() throws IOException {
             File filepath = new File("/Users/michal/Desktop/Codecool/Projects/gender-detector/src/main/resources/female.txt");

            BufferedReader br = new BufferedReader(new FileReader(filepath));
            List<String> namesList =  new ArrayList<>();

            String st;
            while ((st = br.readLine()) != null)
                namesList.add(st);


            return namesList;
        }


}

