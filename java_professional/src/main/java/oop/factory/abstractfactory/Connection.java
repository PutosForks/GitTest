package oop.factory.abstractfactory;

enum ConnectionEnum {
    ORACLE, MSSQL
}

public interface Connection {

    void connect();
}

class OracleConnection implements Connection {
    public void connect() {
        System.out.println("Connecting to Oracle");
    }
}

class MSSQLConnection implements Connection {
    public void connect() {
        System.out.println("Connecting to MSSQL");
    }
}

abstract class ConnectionFactory {
    abstract Connection getConnection();
}

class OracleConnectionFactory extends ConnectionFactory {
    Connection getConnection() {
        return new OracleConnection();
    }
}

class MSSQLConnectionFactory extends ConnectionFactory {
    Connection getConnection() {
        return new MSSQLConnection();
    }
}

class Application {
    public final ConnectionFactory connectionFactory;

    Application(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    void start() {
        Connection connection = connectionFactory.getConnection();
        connection.connect();
    }

}

class testApplication {

    public static void main(String[] args) {
        Application application = new Application(getConnectionFactory(ConnectionEnum.MSSQL));
        application.start();

    }

    private static ConnectionFactory getConnectionFactory(ConnectionEnum connectionenum) {
        ConnectionFactory connectionFactry = null;
        if (connectionenum.equals(ConnectionEnum.MSSQL)) {
            connectionFactry =  new MSSQLConnectionFactory();
        }

        if (connectionenum.equals(ConnectionEnum.ORACLE)) {
            connectionFactry =  new OracleConnectionFactory();
        }
        return connectionFactry;
    }
}