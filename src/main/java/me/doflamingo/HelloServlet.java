package me.doflamingo;

import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("Do Get");
        WebApplicationContext webApplicationContext = (WebApplicationContext) getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        HelloService helloService = webApplicationContext.getBean(HelloService.class);
        resp.getWriter().println("<html>");
        resp.getWriter().println("<header>");
        resp.getWriter().println("</header>");
        resp.getWriter().println("<body>");
        resp.getWriter().println("<h1>Hello "+helloService.getName()+"</h1>");
        resp.getWriter().println("</body>");
        resp.getWriter().println("</html>");
    }

    @Override
    public void destroy() {
        System.out.println("Servlet Destroy");
    }

    @Override
    public void init() {
        System.out.println("Servlet Init");
    }
}
