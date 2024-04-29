



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PizzaService implements DbConnection {
    Connection connection;
    // <тип драйвера>:<тип БД>://<хост>:<порт>/<название БД>
    private final String DB_URL = "jdbc:postgresql://localhost:5432/Notepads";
    private final String USERNAME = "postgres";
    private final String PASSWORD = "Sk3295318";
    private final String DB_DRIVER = "org.postgresql.Driver";

    public PizzaService() {
        try {
            // инициализация  драйвера БД
            Class.forName(DB_DRIVER);
            this.connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Connection not impassible");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not connect");
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Pizza> all() {
        String query = "SELECT * FROM pizza";
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            List<Pizza> result = getALLFromResultSet(resultSet);
            result.forEach(System.out::println);
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Client> allClients() {
        String query = "SELECT * FROM clients";
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            List<Client> result = getALLFromResultSetClients(resultSet);
            result.forEach(System.out::println);
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Pizza add(Pizza pizza) {
        String query = "INSERT INTO pizzas (name, price) VALUES ('"
                .concat(pizza.getName())
                .concat("', ")
                .concat(String.valueOf(pizza.getCost()))
                .concat(");");
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
            return pizza;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Client addClients() {
        String query = "INSERT INTO clients VALUES";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            return new Client(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Pizza> getALLFromResultSet(ResultSet resultSet) throws SQLException {
        List<Pizza> result = new ArrayList<>();
        while (resultSet.next()) {
            result.add(new Pizza(resultSet));
        }
        return result;
    }
    private List<Client> getALLFromResultSetClients(ResultSet resultSet) throws SQLException {
        List<Client> result = new ArrayList<>();
        while (resultSet.next()) {
            result.add(new Client(resultSet));
        }
        return result;
    }

    @Override
    public void close() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

