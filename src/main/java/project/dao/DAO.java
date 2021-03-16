package project.dao;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class DAO  {

        public  List<String> fetchDataFromFile(File filepath) throws IOException {

            BufferedReader br = new BufferedReader(new FileReader(filepath));
            List<String> namesList =  new ArrayList<>();

            String st;
            while ((st = br.readLine()) != null)
                namesList.add(st);


            return namesList;
        }


}

