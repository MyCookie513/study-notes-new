package java基础知识.ConnectionPool;

import java.sql.Connection;

public interface PoolService {

    void Init();
    ConPool.Connection_DIY getConnection();
    void closeAllConnetions();
}
