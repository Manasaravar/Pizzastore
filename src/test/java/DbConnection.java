

import java.util.List;

    public interface DbConnection {
        List<Pizza> all();
        List<Client> allClients();


        Pizza add(Pizza pizza);

        void close();

    }

