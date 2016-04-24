package App;

import SmartMED.*;
import java.sql.*;
import javax.servlet.http.*;

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
            case GenerateRegister:
                GenerateRegister();
                break;
            case ExecuteRegister:
                ExecuteRegister();
                break;
            case ExecuteLogin:
                ExecuteLogin();
                break;
        }

        SetRequest(null);
    }

    private void GenerateRegister()
    {
        Registration registration = (Registration) Session.getAttribute("registration");
        if (registration == null)
        {
            registration = new Registration();
            Session.setAttribute("registration", registration);
        }
        registration.Generate(this);

        SetPage(EPage.Register);
    }

    private void ExecuteRegister()
    {
        String firstname = Request.getParameter("firstname");
        String surname = Request.getParameter("surname");
        String email = Request.getParameter("email");
        String pesel = Request.getParameter("pesel");
        String phone = Request.getParameter("phone");
        String visitID = Request.getParameter("visitID");

        System.out.println(firstname);
        System.out.println(surname);
        System.out.println(email);
        System.out.println(pesel);
        System.out.println(phone);
        System.out.println(visitID);

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

            ResultSet rs = databaseAccess.Select("SELECT id FROM pacjenci WHERE pesel=" + pesel + ";");

            int pacjentID = -1;

            while (rs.next())
            {
                pacjentID = rs.getInt(1);
            }
            System.out.println(pacjentID);

            databaseAccess.ExecuteQuery("UPDATE terminy SET id_pacjent=" + pacjentID + " WHERE id=" + visitID + ";");
        }
        catch (SQLException ex)
        {
            System.err.println(ex);
        }

        SetPage(EPage.RegisterSucces);
    }

    private void ExecuteLogin()
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
            Reception reception = (Reception) Session.getAttribute("reception");
            if (reception == null)
            {
                reception = new Reception();
                Session.setAttribute("reception", reception);
            }
            reception.Generate(this);

            SetPage(EPage.Reception);
        }
        else
        {
            SetPage(EPage.LoginFail);
        }
    }
}
