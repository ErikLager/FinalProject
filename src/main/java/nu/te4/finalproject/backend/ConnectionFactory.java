package nu.te4.finalproject.backend;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author L
 */
public class ConnectionFactory {

    /**
     * Logs information.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ConnectionFactory.class);

    /**
     * Represents whether or not the JDBC driver has been initialized.
     */
    private static boolean initialized = false;

    /**
     * This method does some important initialization to connect to the
     * database. Call this method once before calling the
     * {@link #getConnection() getConnection} method.
     */
    private static void init() throws Exception {
        LOGGER.trace("Trying to create new instance of: {}.","com.mysql.cj.jdbc.Driver");
        Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
    }

    /**
     * Gets a connection to the database.
     *
     * @return A connection to the database.
     * @throws SQLException If the database is unavailable.
     */
    public static Connection getConnection() throws SQLException {
        LOGGER.trace("Checking if connection is not initialized.");
        if (!initialized) {
            LOGGER.info("Database connection not initialized. Initializing now.");
            try {
                LOGGER.info("Initializing JDBC driver.");
                init();
                LOGGER.info("Initializing JDBC driver success.");
                LOGGER.trace("Setting initialized to true.");
                initialized = true;
            } catch (Exception ex) {
                LOGGER.error("Failed to initialize JDBC driver: {}", ex.getMessage());
            }
        }
        LOGGER.trace("Retrieving connection from DriverManager using string: {}", "jdbc:mysql://localhost/finalproject?user=usr&password=");
        Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/finalproject?recources/properties/password");
        LOGGER.info("Connection retrieved.");
        return connection;
    }
}
