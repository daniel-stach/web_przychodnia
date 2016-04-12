package App;

import SmartMED.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            case Login:
                ProcessLogin();
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

        DatabaseAccess databaseAccess = new DatabaseAccess();
        databaseAccess.Connect("localhost/SmartMED", "SmartMED", "*gi3q3r*");

        try
        {
            PreparedStatement stmt = databaseAccess.PrepareStatement("INSERT INTO pacjenci(imie, nazwisko, email, pesel, telefon) VALUES(?, ?, ?, ?, ?);");
            int index = 0;
            stmt.setObject(++index, firstname);
            stmt.setObject(++index, surname);
            stmt.setObject(++index, email);
            stmt.setObject(++index, pesel);
            stmt.setObject(++index, phone);
            stmt.executeUpdate();
        }
        catch (SQLException ex)
        {
            System.err.println(ex);
        }

        SetPage(EPage.RegisterSucces);
    }

    private void ProcessLogin()
    {
        String login = Request.getParameter("login");
        String haslo = Request.getParameter("haslo");

        System.out.println(login);
        System.out.println(haslo);

        DatabaseAccess databaseAccess = new DatabaseAccess();
        databaseAccess.Connect("localhost/SmartMED", "SmartMED", "*gi3q3r*");

        boolean isLogged = false;

        try
        {
            ResultSet rs = databaseAccess.Select("SELECT count(*) FROM konta WHERE login='" + login + "' AND haslo='" + haslo + "';");

            while (rs.next())
            {
                isLogged = rs.getInt(1) > 0;
            }
        }
        catch (SQLException ex)
        {
            System.err.println(ex);
        }

        if (isLogged)
        {
            SetPage(EPage.Reception);
        }
        else
        {
            SetPage(EPage.LoginFail);
        }
    }
}
