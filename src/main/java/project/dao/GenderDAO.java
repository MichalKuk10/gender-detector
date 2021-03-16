package project.dao;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface GenderDAO {

    boolean checkIfTokenExists(String filepath, String name);

    String fetchFemaleNamesFromDatabase() throws IOException;

    String fetchMaleNamesFromDatabase() throws IOException;
}
