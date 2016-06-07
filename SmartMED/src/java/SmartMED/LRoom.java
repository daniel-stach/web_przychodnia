package SmartMED;

import App.*;
import java.sql.*;
import java.text.*;

public class LRoom
{
    private String HtmlTableRows = "";
    private String HtmlTableRows2 = "";

    public void Generate(Controller controller)
    {
        HtmlTableRows = "";

        DatabaseAccess databaseAccess = new DatabaseAccess();
        databaseAccess.Connect("localhost/SmartMED", "SmartMED", "*gi3q3r*");

        try
        {
            // tabela 1
            ResultSet rs = databaseAccess.Select("SELECT imie, nazwisko, email, pesel, telefon FROM  pacjenci;");

            while (rs.next())
            {
                HtmlTableRows += "<tr>";

                int p = 0;
                HtmlTableRows += "<td>" + rs.getObject(++p) + "</td>";
                HtmlTableRows += "<td>" + rs.getObject(++p) + "</td>";
                HtmlTableRows += "<td>" + rs.getObject(++p) + "</td>";
                HtmlTableRows += "<td>" + rs.getObject(++p) + "</td>";
                HtmlTableRows += "<td>" + rs.getObject(++p) + "</td>";

                HtmlTableRows += "</tr>";
            }

            // tabela 2
            HtmlTableRows2 = "";

            ResultSet rs2 = databaseAccess.Select("SELECT p.imie, p.nazwisko, pi.info FROM pacjenci_info AS pi INNER JOIN pacjenci AS p ON p.id=pi.id_pacjent");

            while (rs2.next())
            {
                HtmlTableRows2 += "<tr>";

                int p = 0;
                HtmlTableRows2 += "<td>" + rs2.getObject(++p) + "</td>";
                HtmlTableRows2 += "<td>" + rs2.getObject(++p) + "</td>";
                HtmlTableRows2 += "<td>" + rs2.getObject(++p) + "</td>";

                HtmlTableRows2 += "</tr>";
            }
        }
        catch (SQLException ex)
        {
            System.err.println(ex);
        }
    }

    // java bean getters
    public String getHtmlTableRows()
    {
        return HtmlTableRows;
    }

    public String getHtmlTableRows2()
    {
        return HtmlTableRows2;
    }
}
