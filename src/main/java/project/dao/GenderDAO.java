package project.dao;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface GenderDAO {

    boolean fetchTokensByName(String filepath, String name);

    String fetchAllNamesFromDatabase(File filepath) throws IOException;
}
