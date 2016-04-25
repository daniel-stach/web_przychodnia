package SmartMED;

import App.*;
import java.sql.*;
import java.text.*;

public class Reception
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
            ResultSet rs = databaseAccess.Select("SELECT l.imie, l.nazwisko, t.data, p.imie, p.nazwisko, p.email, p.pesel, p.telefon FROM terminy AS t INNER JOIN pacjenci AS p ON t.id_pacjent=p.id INNER JOIN lekarze AS l ON t.id_lekarz=l.id WHERE id_pacjent IS NOT NULL;");

            while (rs.next())
            {
                HtmlTableRows += "<tr>";

                int p = 0;
                HtmlTableRows += "<td>" + rs.getObject(++p) + " " + rs.getObject(++p) + "</td>";
                String date = rs.getString(++p);
                SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                SimpleDateFormat df2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                try
                {
                    java.util.Date date2 = (java.util.Date) df1.parse(date);
                    date = df2.format(date2);
                    //System.out.println(date);
                }
                catch (ParseException ex)
                {
                    System.err.println(ex);
                }
                HtmlTableRows += "<td>" + date + "</td>";
                HtmlTableRows += "<td>" + rs.getObject(++p) + " " + rs.getObject(++p) + "</td>";
                HtmlTableRows += "<td>" + rs.getObject(++p) + "</td>";
                HtmlTableRows += "<td>" + rs.getObject(++p) + "</td>";
                HtmlTableRows += "<td>" + rs.getObject(++p) + "</td>";

                HtmlTableRows += "<td>"
                        + "    <a href=\"#\" class=\"mdl-button mdl-js-button mdl-button--raised\">"
                        + "                                    Edytuj"
                        + "                                </a> &nbsp;"
                        + "    <a href=\"#\" class=\"mdl-button mdl-js-button mdl-button--raised\">"
                        + "                                    Usuń"
                        + "                                </a>"
                        + "</td>";

                HtmlTableRows += "</tr>";
            }

            // tabela 2
            HtmlTableRows2 = "";

            ResultSet rs2 = databaseAccess.Select("SELECT l.imie, l.nazwisko, t.data FROM terminy AS t INNER JOIN lekarze AS l ON t.id_lekarz=l.id");

            while (rs2.next())
            {
                HtmlTableRows2 += "<tr>";

                int p = 0;
                HtmlTableRows2 += "<td>" + rs2.getObject(++p) + " " + rs2.getObject(++p) + "</td>";
                String date = rs2.getString(++p);
                SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                SimpleDateFormat df2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                try
                {
                    java.util.Date date2 = (java.util.Date) df1.parse(date);
                    date = df2.format(date2);
                    //System.out.println(date);
                }
                catch (ParseException ex)
                {
                    System.err.println(ex);
                }
                HtmlTableRows2 += "<td>" + date + "</td>";
                HtmlTableRows2 += "<td> - </td>";
                HtmlTableRows2 += "<td> - </td>";
                HtmlTableRows2 += "<td> - </td>";
                HtmlTableRows2 += "<td> - </td>";

                HtmlTableRows2 += "<td>"
                        + "    <a href=\"#\" class=\"mdl-button mdl-js-button mdl-button--raised\">"
                        + "                                    Edytuj"
                        + "                                </a> &nbsp;"
                        + "    <a href=\"#\" class=\"mdl-button mdl-js-button mdl-button--raised\">"
                        + "                                    Usuń"
                        + "                                </a>"
                        + "</td>";

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
