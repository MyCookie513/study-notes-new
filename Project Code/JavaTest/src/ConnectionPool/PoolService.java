package ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;

public interface PoolService {

    void Init();
    ConPool.Connection_DIY getConnection();
    void closeAllConnetions()throws SQLException;
}
