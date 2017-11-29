
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* NO IMPLEMENTADO */
@WebServlet(name = "/Confirmation", urlPatterns = {"/Confirmation"})
public class Confirmation extends HttpServlet {
   
    private static final Logger logger = Logger.getLogger(Confirmation.class.getName());
    private static final String header = "<!DOCTYPE html>\n<html>\n<head>\n<title>Servlet Confirmation</title>\n</head>\n<body>\n";
    private static final String footer = "</body>\n</html>";
    private String body;
    private PrintWriter out;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException,IOException{
        response.setContentType("text/html;charset=UTF-8");


        out = response.getWriter();
        out.println(header);
        out.println(body);
        out.println(footer);
        out.close();
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Servlet Confirmation";
    }
}
