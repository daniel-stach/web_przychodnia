package SmartMED;

import App.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class Edit
{
    private String Inputs ="";
    private String Html;

    SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat df2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");

    public void Generate(Controller controller)
    {
        Html = "";

        DatabaseAccess databaseAccess = new DatabaseAccess();
        databaseAccess.Connect("localhost/SmartMED", "SmartMED", "*gi3q3r*");

        try
        {
            String id = controller.GetRequest().getParameter("id");
            if (id != null)
            {
                System.out.println(id);

                String no = controller.GetRequest().getParameter("no");

                if (no == null)
                {
                    Inputs =  "                        <div class=\"mdl-textfield mdl-js-textfield mdl-textfield--floating-label\">\n"
                            + "                            <input id=\"in3\" class=\"mdl-textfield__input\" type=\"text\" pattern=\"[A-Z,a-z]*\"  name=\"firstname2\">\n"
                            + "                            <label class=\"mdl-textfield__label\" for=\"firstname2\">Imię pacjenta</label>\n"
                            + "                            <span class=\"mdl-textfield__error\">Tylko znaki alfabetu i bez spacji</span>\n"
                            + "                        </div>\n"
                            + "                        <div class=\"mdl-textfield mdl-js-textfield mdl-textfield--floating-label\">\n"
                            + "                            <input id=\"in4\" class=\"mdl-textfield__input\" type=\"text\" pattern=\"[A-Z,a-z]*\" id=\"surname\" name=\"surname2\">\n"
                            + "                            <label class=\"mdl-textfield__label\" for=\"surname2\">Nazwisko pacjenta</label>\n"
                            + "                            <span class=\"mdl-textfield__error\">Tylko znaki alfabetu i bez spacji</span>\n"
                            + "                        </div>\n"
                            + "\n"
                            + "                        <div class=\"mdl-textfield mdl-js-textfield mdl-textfield--floating-label\">\n"
                            + "                            <input id=\"in5\" class=\"mdl-textfield__input\" type=\"email\" id=\"email\" name=\"email\">\n"
                            + "                            <label class=\"mdl-textfield__label\" for=\"email\">Email</label>\n"
                            + "                            <span class=\"mdl-textfield__error\">Niepoprawny adres email</span>\n"
                            + "                        </div>\n"
                            + "                        <div class=\"mdl-textfield mdl-js-textfield mdl-textfield--floating-label\">\n"
                            + "                            <input id=\"in6\" class=\"mdl-textfield__input\" type=\"text\" pattern=\"[0-9]{11}\" id=\"pesel\" name=\"pesel\">\n"
                            + "                            <label class=\"mdl-textfield__label\" for=\"pesel\">Pesel</label>\n"
                            + "                            <span class=\"mdl-textfield__error\">Niepoprawny numer pesel</span>\n"
                            + "                        </div>\n"
                            + "                        <div class=\"mdl-textfield mdl-js-textfield mdl-textfield--floating-label\">\n"
                            + "                            <input id=\"in7\" class=\"mdl-textfield__input\" type=\"text\" pattern=\"[0-9]{9}\" id=\"phone\" name=\"phone\">\n"
                            + "                            <label class=\"mdl-textfield__label\" for=\"phone\">Telefon</label>\n"
                            + "                            <span class=\"mdl-textfield__error\">Niepoprawny numer telefonu</span>\n"
                            + "                        </div>";

                    ResultSet rs = databaseAccess.Select("SELECT l.imie, l.nazwisko, t.data, p.imie, p.nazwisko, p.email, p.pesel, p.telefon, t.id FROM terminy AS t INNER JOIN pacjenci AS p ON t.id_pacjent=p.id INNER JOIN lekarze AS l ON t.id_lekarz=l.id WHERE t.id=" + id + ";");

                    int p = 0;
                    while (rs.next())
                    {
                        System.out.println("Lorem1");
                        Html += "$('#in" + p + "').val('" + rs.getString(++p) + "');";
                        Html += "$('#in" + p + "').val('" + rs.getString(++p) + "');";
                        Html += "$('#in" + p + "').val('" + rs.getString(++p) + "');";
                        Html += "$('#in" + p + "').val('" + rs.getString(++p) + "');";
                        Html += "$('#in" + p + "').val('" + rs.getString(++p) + "');";
                        Html += "$('#in" + p + "').val('" + rs.getString(++p) + "');";
                        Html += "$('#in" + p + "').val('" + rs.getString(++p) + "');";
                        Html += "$('#in" + p + "').val('" + rs.getString(++p) + "');";
                        Html += "$('#in" + p + "').val('" + rs.getString(++p) + "');";
                    }
                }
                else
                {
                    Inputs = "";

                    ResultSet rs = databaseAccess.Select("SELECT l.imie, l.nazwisko, t.data, t.id FROM terminy AS t INNER JOIN lekarze AS l ON t.id_lekarz=l.id WHERE t.id=" + id + ";");

                    int p = 0;
                    while (rs.next())
                    {
                        System.out.println("Lorem2");
                        Html += "$('#in" + p + "').val('" + rs.getString(++p) + "');";
                        Html += "$('#in" + p + "').val('" + rs.getString(++p) + "');";
                        Html += "$('#in" + p + "').val('" + rs.getString(++p) + "');";
                        Html += "$('#in" + 8 + "').val('" + rs.getString(++p) + "');";
                    }
                }
            }
        }
        catch (SQLException ex)
        {
            System.err.println(ex);
        }

        System.out.println(Html);
    }

    // java bean getters
    public String getHtml()
    {
        return Html;
    }

    public String getInputs()
    {
        return Inputs;
    }
}
