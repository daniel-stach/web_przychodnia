package App;

import SmartMED.*;
import java.sql.*;
import javax.servlet.http.*;

public class Controller
{
    private HttpServletRequest Request;
    private HttpSession Session;
    private EPage ResultPage;

    private boolean BackToR = false;

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
                BackToR = false;
                GenerateRegister();
                break;
            case GenerateRegister2:
                BackToR = true;
                GenerateRegister();
                break;
            case GenerateReception:
                GenerateReception();
                break;
            case GenerateLRoom:
                GenerateLRoom();
                break;
            case ExecuteAdd:
                ExecuteAdd();
                break;
            case GenerateAdd:
                GenerateAdd();
                break;
            case GenerateEdit:
                GenerateEdit();
                break;
            case ExecuteRegister:
                ExecuteRegister();
                break;
            case ExecuteEdit:
                ExecuteEdit();
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

        if (BackToR)
        {
            SetPage(EPage.Register2);
        }
        else
        {
            SetPage(EPage.Register);
        }
    }

    private void GenerateReception()
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

    private void GenerateLRoom()
    {
        LRoom lroom = (LRoom) Session.getAttribute("lroom");
        if (lroom == null)
        {
            lroom = new LRoom();
            Session.setAttribute("lroom", lroom);
        }
        lroom.Generate(this);

        SetPage(EPage.LROOM);
    }

    private void GenerateAdd()
    {
        SetPage(EPage.Add);
    }

    private void ExecuteAdd()
    {
        String firstname = Request.getParameter("firstname");
        String surname = Request.getParameter("surname");
        String data = Request.getParameter("data");

        System.out.println(firstname);
        System.out.println(surname);
        System.out.println(data);

        DatabaseAccess databaseAccess = new DatabaseAccess();
        databaseAccess.Connect("localhost/SmartMED", "SmartMED", "*gi3q3r*");

        try
        {
            ResultSet rs = databaseAccess.Select("SELECT id FROM pacjenci WHERE imie='" + firstname + "' AND nazwisko='" + surname + "';");
            int idp = -1;
            while (rs.next())
            {
                idp = rs.getInt(1);
            }
            System.out.println("idp: " + idp);
            if (idp == -1)
            {
                databaseAccess.ExecuteQuery("INSERT INTO pacjenci(imie, nazwisko, email, pesel, telefon) VALUES('" + firstname + "', '" + surname + "', '', '', '');");
            }
            ResultSet rs2 = databaseAccess.Select("SELECT id FROM pacjenci WHERE imie='" + firstname + "' AND nazwisko='" + surname + "';");
            while (rs2.next())
            {
                idp = rs2.getInt(1);
            }
            System.out.println("idp: " + idp);
            databaseAccess.ExecuteQuery("INSERT INTO pacjenci_info(info, id_pacjent) VALUES('" + data + "', " + idp + ");");
        }
        catch (SQLException ex)
        {
            System.err.println(ex);
        }

        GenerateLRoom();
        SetPage(EPage.LROOM);
    }

    private void GenerateEdit()
    {
        Edit edit = (Edit) Session.getAttribute("edit");
        if (edit == null)
        {
            edit = new Edit();
            Session.setAttribute("edit", edit);
        }
        edit.Generate(this);

        SetPage(EPage.Edit);
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

        if (BackToR)
        {
            GenerateReception();
            SetPage(EPage.Reception);
        }
        else
        {
            SetPage(EPage.RegisterSucces);
        }
    }

    private void ExecuteEdit()
    {
        String firstname = Request.getParameter("firstname");
        String surname = Request.getParameter("surname");
        String data = Request.getParameter("data");
        String firstname2 = Request.getParameter("firstname2");
        String surname2 = Request.getParameter("surname2");
        String email = Request.getParameter("email");
        String pesel = Request.getParameter("pesel");
        String phone = Request.getParameter("phone");
        String id = Request.getParameter("id");

        System.out.println(firstname);
        System.out.println(surname);
        System.out.println(data);
        System.out.println(firstname2);
        System.out.println(surname2);
        System.out.println(email);
        System.out.println(pesel);
        System.out.println(phone);
        System.out.println(id);

        DatabaseAccess databaseAccess = new DatabaseAccess();
        databaseAccess.Connect("localhost/SmartMED", "SmartMED", "*gi3q3r*");

        try
        {
            if (id != null && id != "")
            {
                databaseAccess.ExecuteQuery("UPDATE terminy SET data='" + data + "' WHERE id=" + id + ";");

                ResultSet rs = databaseAccess.Select("SELECT id_lekarz, id_pacjent FROM terminy WHERE id=" + id + ";");
                int idp = 0;
                int idl = 0;
                while (rs.next())
                {
                    idl = rs.getInt(1);
                    idp = rs.getInt(2);
                }
                String ss = "UPDATE pacjenci SET imie='" + firstname2 + "', nazwisko='" + surname2 + "', email='" + email + "', pesel='" + pesel + "', telefon='" + phone + "' WHERE id=" + idp + ";";
                System.out.println(ss);
                databaseAccess.ExecuteQuery(ss);

                String sss = "UPDATE lekarze SET imie='" + firstname + "', nazwisko='" + surname + "' WHERE id=" + idl + ";";
                System.out.println(sss);
                databaseAccess.ExecuteQuery(sss);
            }
            else
            {
                System.out.println("elo");
                ResultSet rs = databaseAccess.Select("SELECT id FROM lekarze WHERE imie='" + firstname + "' AND nazwisko='" + surname + "';");
                int idl = -1;
                while (rs.next())
                {
                    idl = rs.getInt(1);
                }
                System.out.println("idl: " + idl);
                if (idl == -1)
                {
                    databaseAccess.ExecuteQuery("INSERT INTO lekarze(imie, nazwisko, specjalizacja) VALUES('" + firstname + "', '" + surname + "','');");
                }
                ResultSet rs2 = databaseAccess.Select("SELECT id FROM lekarze WHERE imie='" + firstname + "' AND nazwisko='" + surname + "';");
                while (rs2.next())
                {
                    idl = rs2.getInt(1);
                }
                System.out.println("idl: " + idl);
                databaseAccess.ExecuteQuery("INSERT INTO terminy(data, id_lekarz) VALUES('" + data + "', " + idl + ");");
            }
        }
        catch (SQLException ex)
        {
            System.err.println(ex);
        }

        GenerateReception();
        SetPage(EPage.Reception);
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
            if ("Arnold".equals(login))
            {
                GenerateLRoom();
            }
            else
            {
                GenerateReception();
            }
        }
        else
        {
            SetPage(EPage.LoginFail);
        }
    }
}
