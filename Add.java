
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "/Add", urlPatterns = {"/Add"})
public class Add extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(Add.class.getName());
    private static final String PATH = "./index.jsp";
    private static final String ACTION = "Add";
    private Service service;
    private RequestDispatcher dispatcher;
    private Car car;
    private boolean success = false;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        service = new Service();
        car = new Car(request.getParameter("license").toLowerCase());
        if (car.getLicense() != null && !car.getLicense().equals("")) {
            car.setModel(request.getParameter("model").toLowerCase());
            car.setBrand(request.getParameter("brand").toLowerCase());
            car.setColor(request.getParameter("color").toLowerCase());
            request.setAttribute("action", ACTION);
            if (service.addCar(car) != null) {
                success = true;
            }
            request.setAttribute("success", success);
            request.setAttribute("car", car);
            request.setAttribute("list", service.findAll());
            dispatcher = request.getRequestDispatcher(PATH);
            dispatcher.forward(request, response);
        } else {
            LOGGER.log(Level.INFO, "Parámetro incorrecto" + this.getServletInfo());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet Add";
    }

}
