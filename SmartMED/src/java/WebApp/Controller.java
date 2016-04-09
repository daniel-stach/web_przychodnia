package WebApp;

import SmartMED.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Controller
{
    private HttpServletRequest Request;
    private HttpSession Session;
    private EPage ResultPage;

    public HttpServletRequest GetRequest()
    {
        return Request;
    }

    public void SetRequest(HttpServletRequest request)
    {
        Request = request;
    }
    
    public HttpSession GetSession()
    {
        return Session;
    }

    public void SetSession(HttpSession session)
    {
        Session = session;
    }

    public String GetAppLink(EOperation operation)
    {
        return "App?" + EOperation.OperationParamName + "=" + operation.OperationCode;
    }

    private void SetPage(EPage resultPage)
    {
        ResultPage = resultPage;
    }

    public EPage GetPage()
    {
        return ResultPage;
    }

    public void ProcessRequest(javax.servlet.http.HttpServletRequest request)
    {
        SetRequest(request);

        SetPage(null);

        switch (EOperation.ParseString(GetRequest().getParameter("op")))
        {
            case Example:
                ProcessExample();
                break;
            case Register:
                ProcessRegister();
                break;
        }

        SetRequest(null);
    }

    private void ProcessExample()
    {
        Example example = (Example) Session.getAttribute("example");
        if (example == null)
        {
            example = new Example();
            Session.setAttribute("example", example);
        }
        example.Generate(this);

        SetPage(EPage.Example);
    }

    private void ProcessRegister()
    {
        String firstname = Request.getParameter("firstname");
        String surname = Request.getParameter("surname");
        String email = Request.getParameter("email");
        String pesel = Request.getParameter("pesel");
        String phone = Request.getParameter("phone");

        System.out.println(firstname);
        System.out.println(surname);
        System.out.println(email);
        System.out.println(pesel);
        System.out.println(phone);

        SetPage(EPage.RegisterSucces);
    }
}
