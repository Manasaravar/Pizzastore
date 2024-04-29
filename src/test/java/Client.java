import java.sql.ResultSet;
import java.sql.SQLException;

public class Client {
    private Integer id;
    private String client;
    private String phone;
    private String emailClient;
    private String addressDelivery;

    public Client(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("id");
        this.client = resultSet.getString("Имя клиента");
        this.phone = resultSet.getString("Телефон");
        this.emailClient = resultSet.getString("Email");
        this.addressDelivery = resultSet.getString("Адрес доставки");
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmailClient() {
        return emailClient;
    }

    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }

    public String getAddressDelivery() {
        return addressDelivery;
    }

    public void setAddressDelivery(String addressDelivery) {
        this.addressDelivery = addressDelivery;
    }

    public Client(String client, String phone, String emailClient, String addressDelivery) {
        this.client = client;
        this.phone = phone;
        this.emailClient = emailClient;
        this.addressDelivery = addressDelivery;
    }

    @Override
    public String toString() {
        return "Client{" +
                "client='" + client + '\'' +
                ", phone='" + phone + '\'' +
                ", emailClient='" + emailClient + '\'' +
                ", addressDelivery='" + addressDelivery + '\'' +
                '}';
    }
}
