package SmartMED;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class App extends HttpServlet
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession httpSession = request.getSession();
        AppSession appSession = (AppSession) httpSession.getAttribute("appSession");
        Controller controller = appSession.GetController();

        if (controller == null)
        {
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        controller.BeginRequest(request);
        controller.ProcessRequest();
        controller.EndRequest();

        EWebPage resultPage = controller.GetResultPage();
        if (resultPage == null)
        {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        else
        {
            request.getRequestDispatcher(resultPage.PageURL).forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo()
    {
        return "Servlet Info";
    }
}
