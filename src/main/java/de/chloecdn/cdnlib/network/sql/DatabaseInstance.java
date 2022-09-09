package de.chloecdn.cdnlib.network.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseInstance {

    private Connection connection;
    private boolean connected;

    public DatabaseInstance(String ip, int port, String database, String user, String pass) {
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://" + ip + "/" + database, user, pass);
            this.connected = true;
        } catch (SQLException e) {
            this.connection = null;
            this.connected = true;
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public boolean isConnected() {
        return connected;
    }
}
