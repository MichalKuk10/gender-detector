package project.service;

import org.springframework.stereotype.Service;
import project.dao.DAO;

import java.io.IOException;
import java.util.List;

@Service
public class GenderService {

    public DAO dao;

    public GenderService(DAO dao) {
        this.dao = dao;
    }

    public String checkGender(String name) throws IOException {

        try {
            List<String> stringList = dao.fetchFemaleData();
            for (String element : stringList){
                if (element.equals(name)){
                    return "FEMALE";
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return "MALE";
    }


}
