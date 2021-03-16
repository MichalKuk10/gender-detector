package project.dao;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface GenderDAO {

    public List<String> fetchTokens(File filepath);
}
