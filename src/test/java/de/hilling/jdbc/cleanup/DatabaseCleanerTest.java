package de.hilling.jdbc.cleanup;

import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

public class DatabaseCleanerTest extends AbstractCleanupTest {
    private DatabaseCleaner cleaner;

    @Before
    public void setUp() {
        cleaner = new DatabaseCleaner();
    }

    @Test
    public void cleanUpEmpty() throws SQLException {
        cleaner.run(connection);
    }
}