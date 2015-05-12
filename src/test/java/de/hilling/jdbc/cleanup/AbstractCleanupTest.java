package de.hilling.jdbc.cleanup;

import org.junit.After;
import org.junit.Before;

import java.sql.Connection;
import java.sql.SQLException;

public class AbstractCleanupTest {
    protected Connection connection;
    protected ConnectionUtil connectionUtil;
    protected GenericConstraintDisabler disabler;

    @Before
    public final void setUpBaseTest() {
        connection = H2ConnectionCreator.create();
        connectionUtil = new ConnectionUtil();
        connectionUtil.setConnection(connection);
        connectionUtil.execute("CREATE TABLE person(" +
                "fk_name VARCHAR(32)," +
                "id INTEGER," +
                "parent INTEGER," +
                "PRIMARY KEY(id)," +
                "FOREIGN KEY(parent) REFERENCES person(id)" +
                ");");
        disabler = new GenericConstraintDisabler(new ConnectionInfo(connection));
    }

    @After
    public final void tearDownBaseTest() throws SQLException {
        connection.close();
    }
}
