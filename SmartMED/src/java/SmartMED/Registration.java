package SmartMED;

import App.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.*;

public class Registration
{
    private String HtmlVisits;

    public void Generate(Controller controller)
    {
        HtmlVisits = "";

        DatabaseAccess databaseAccess = new DatabaseAccess();
        databaseAccess.Connect("localhost/SmartMED", "SmartMED", "*gi3q3r*");

        try
        {
            ResultSet rs = databaseAccess.Select("SELECT t.id, t.`data`, l.imie, l.nazwisko, l.specjalizacja FROM terminy AS t INNER JOIN lekarze AS l ON t.id_lekarz = l.id WHERE id_pacjent IS NULL AND t.`data` > Now();");

            int radioIterator = 0;

            while (rs.next())
            {
                ++radioIterator;

                int p = 0;
                String visitID = rs.getString(++p);
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
                String name = rs.getString(++p);
                String surname = rs.getString(++p);
                String specialization = rs.getString(++p);

                HtmlVisits
                        += "<li class=\"mdl-list__item mdl-list__item--three-line\">\n"
                        + "    <span class=\"mdl-list__item-primary-content\">\n"
                        + "        <i class=\"icon icon-person\" style=\"font-size: 50px; float: left; color: dimgray;\"></i>\n"
                        + "        <span>" + name + " " + surname + "</span>\n"
                        + "        <span class=\"mdl-list__item-text-body\">Specjalizacja: <span style=\"color:#3F51B5\">" + specialization + "</span><br>Termin wizyty: <span style=\"color:#009688;\">" + date + "</span></span>\n"
                        + "    </span>\n"
                        + "    <span class=\"mdl-list__item-secondary-action\">\n"
                        + "        <label class=\"mdl-radio mdl-js-radio mdl-js-ripple-effect\" for=\"list-option-" + radioIterator + "\">\n"
                        + "            <input type=\"radio\" id=\"list-option-" + radioIterator + "\" class=\"mdl-radio__button\" name=\"visitID\" value=\"" + visitID + "\"/>\n"
                        + "        </label>\n"
                        + "    </span>\n"
                        + "</li>";
            }
        }
        catch (SQLException ex)
        {
            System.err.println(ex);
        }
    }

    // java bean getters
    public String getHtmlVisits()
    {
        return HtmlVisits;
    }
}
