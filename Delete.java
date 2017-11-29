
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "/Delete", urlPatterns = {"/Delete"})
public class Delete extends HttpServlet {

    private static final Logger logger = Logger.getLogger(Delete.class.getName());
    private static final String PATH = "./index.jsp";
    private static final String ACTION = "Delete";
    private Service service;
    private RequestDispatcher dispatcher;
    private Car car;
    private Car deleted;
    private boolean success = false;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        service = new Service();
        car = new Car(request.getParameter("license"));
        if (car.getLicense() != null && !car.getLicense().equals("")) {
            request.setAttribute("action", ACTION);
            car = service.deleteCar(car);
            if (car != null) {
                success = true;
            }
            request.setAttribute("success", success);
            request.setAttribute("car", car);
            request.setAttribute("list", service.findAll());
            dispatcher = request.getRequestDispatcher(PATH);
            dispatcher.forward(request, response);
        } else {
            logger.log(Level.INFO, "Parámetro incorrecto" + this.getServletInfo());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet Delete";
    }
}
