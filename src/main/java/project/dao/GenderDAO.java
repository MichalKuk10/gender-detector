package project.dao;

import java.io.IOException;

public interface GenderDAO {

    boolean checkIfTokenExists(String filepath, String name);

    String fetchFemaleNamesFromDatabase();

    String fetchMaleNamesFromDatabase();
}
