package Repository;

import DataAccess.FileDAO;

public class FileRepository implements IFileRepository {

    @Override
    public void readFileConfig() {
        FileDAO.Instance().readFileConfig();
    }
}
