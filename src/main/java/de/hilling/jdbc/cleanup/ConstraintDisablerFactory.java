package de.hilling.jdbc.cleanup;

public class ConstraintDisablerFactory {
    /**
     * Build constraint disabler for given de.hilling.jdbc.cleanup.ConnectionInfo.
     * @param info
     * @return de.hilling.jdbc.cleanup.ConstraintDisabler or null if not available.
     */
    public static ConstraintDisabler create(ConnectionInfo info) {
        switch (info.getType()) {
            case H2:
                return new H2ConstraintDisabler(info);
            case MYSQL:
                return new MysqlConstraintDisabler(info);
            default:
                return null;
        }
    }
}
