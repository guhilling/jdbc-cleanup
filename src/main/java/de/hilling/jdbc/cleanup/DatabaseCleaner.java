package de.hilling.jdbc.cleanup;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Cleanup database.
 *
 * <p>
 * Brute force implementation. You might replace this by subclassing this implementation
 * and adding {#de.hilling.junit.cdi.annotations.TestImplementation}.
 * </p>
 */
public class DatabaseCleaner {

    public static final String USER_TABLE_IDENTIFIER = "TABLE";

    public void run(Connection connection) throws SQLException {
        ConstraintDisabler constraintDisabler = ConstraintDisablerFactory.create(new ConnectionInfo(connection));
        if(constraintDisabler == null) {
        } else {
            constraintDisabler.disableConstraints();
            deleteTableContents(connection);
            constraintDisabler.enableConstraints();
        }
    }

    private void deleteTableContents(Connection connection) throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet tables = metaData.getTables(null, null, null, new String[]{USER_TABLE_IDENTIFIER});
        while (tables.next()) {
            String tableName = tables.getString(3);
            if (!tableName.equals("SEQUENCE")) {
                connection.prepareStatement("delete from " + tableName).execute();
            }
        }
        connection.commit();
    }
}
