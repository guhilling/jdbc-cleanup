package de.hilling.jdbc.cleanup;

/**
 * Disable and enable constraints for certain db types.
 */
public interface ConstraintDisabler {
    /**
     * After calling all contraints on the connection will be disabled.
     */
    void disableConstraints();

    /**
     * After this call all constraints will be enabled.
     * <p>
     *     Note that all constraints will be enabled, not only those that where disabled
     *     in a previous call to {@link #disableConstraints()}.
     * </p>
     */
    void enableConstraints();
}
