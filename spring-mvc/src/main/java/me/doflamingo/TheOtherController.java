package me.doflamingo;


import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TheOtherController implements HttpRequestHandler {

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("<html>");
        response.getWriter().println("<header>");
        response.getWriter().println("</header>");
        response.getWriter().println("<body>");
        response.getWriter().println("<h1>Hello the Other!!</h1>");
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }
}
