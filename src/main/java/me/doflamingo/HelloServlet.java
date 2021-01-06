package me.doflamingo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Do Get");
        resp.getWriter().println("<html>");
        resp.getWriter().println("<header>");
        resp.getWriter().println("</header>");
        resp.getWriter().println("<body>");
        resp.getWriter().println("<h1>Hello Servlet</h1>");
        resp.getWriter().println("</body>");
        resp.getWriter().println("</html>");

    }

    @Override
    public void destroy() {
        System.out.println("Servlet Destroy");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Servlet Init");
    }
}
