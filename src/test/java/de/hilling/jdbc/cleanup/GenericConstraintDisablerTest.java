package de.hilling.jdbc.cleanup;

import org.junit.Test;

public class GenericConstraintDisablerTest extends AbstractCleanupTest {


    @Test(expected = RuntimeException.class)
    public void insertFails()   {
         connectionUtil.execute("INSERT INTO person VALUES ('gunnar', 0, 1)");
    }

    @Test
    public void testDisableConstraints()  {
        disabler.disableConstraints();
        connectionUtil.execute("INSERT INTO person VALUES ('gunnar', 0, 1)");
    }

    @Test(expected = RuntimeException.class)
    public void testReEnableConstraints()  {
        disabler.disableConstraints();
        disabler.enableConstraints();
        connectionUtil.execute("INSERT INTO person VALUES ('gunnar', 0, 1)");
    }
}