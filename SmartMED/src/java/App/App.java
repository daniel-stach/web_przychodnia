package App;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class App extends HttpServlet
{
    Controller MyController = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession(true);

        if (MyController == null)
        {
            MyController = new Controller();
        }

        MyController.SetSession(session);

        MyController.ProcessRequest(request);

        EPage page = MyController.GetPage();

        if (page == null)
        {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        else
        {
            request.getRequestDispatcher(page.URL).forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo()
    {
        return "Servlet Info";
    }
}
