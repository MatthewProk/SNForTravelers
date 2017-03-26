package connectionpool;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConnectionPoolTest {

    ConnectionPool connectionPool = new ConnectionPool();

    @Test
    public void takeConnection() throws Exception {
        assertNotNull(connectionPool.takeConnection());
    }

}