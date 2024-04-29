import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name = "addServlet", value = "/add")
public class addServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // исполнение логики запроса
        //completeRequest(request);
        response.setContentType("text/html");
        DbConnection service = new PizzaService();
        Pizza carbonara = new Pizza(333,"Карбонара", 1000);
      //  Client newClient = new Client(444,"Bruce Lee", "89153298765", "lee@mail.ru","Москва, Варшавское шоссе д.2");
        service.add(carbonara);
        service.close();
//        RequestDispatcher dispatcher = request
//                .getServletContext()
//                .getRequestDispatcher("/allOrders.jsp");
//        dispatcher.forward(request, response);

    }
// добавляю заказ здесь
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {

            TypeOfPizza name = TypeOfPizza.valueOf(req.getParameter("nameP"));
            String size = req.getParameter("sizePizza");
            String topping = req.getParameter("topping");
            String client = req.getParameter("client");
            String phone = req.getParameter("phone");
            String emailClient = req.getParameter("emailClient");
            String addressDelivery = req.getParameter("addressDelivery");


//            req.setAttribute("orderPizza", orderPizza);
//            req.setAttribute("orderClient", orderClient);
            doGet(req, resp);

        }
        catch(Exception e) {

            getServletContext().getRequestDispatcher("/add.jsp").forward(req, resp);
        }
    }
//    private void completeRequest(HttpServletRequest request) {
//        DbConnection service = new PizzaService();
//        List<Pizza> orderPizza = service.all();
//        List<Client> orderClient = service.allClients();
//        service.close();
//        request.setAttribute("orderPizza", orderPizza);
//        request.setAttribute("orderClient", orderClient);
   // }
}
