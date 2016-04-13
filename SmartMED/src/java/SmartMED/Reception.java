package SmartMED;

import App.Controller;
import App.DatabaseAccess;
import java.sql.*;

public class Reception
{
    private String HtmlTableRows;

    public void Generate(Controller controller)
    {
        HtmlTableRows = "";

        DatabaseAccess databaseAccess = new DatabaseAccess();
        databaseAccess.Connect("localhost/SmartMED", "SmartMED", "*gi3q3r*");

        try
        {
            ResultSet rs = databaseAccess.Select("SELECT * FROM pacjenci;");

            while (rs.next())
            {
                HtmlTableRows += "<tr>";
                
                HtmlTableRows += "<td>TODO</td>";
                HtmlTableRows += "<td>TODO</td>";
                
                for (int i = 2; i <= 6; ++i)
                {
                    HtmlTableRows += "<td>" + rs.getObject(i) + "</td>";
                }

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
}
