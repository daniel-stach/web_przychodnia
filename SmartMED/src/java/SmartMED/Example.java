package SmartMED;

import WebApp.Controller;
import javax.servlet.http.HttpServletRequest;

public class Example
{
    private String Text = "Elo520";

    public void Generate(Controller controller)
    {
        HttpServletRequest request = controller.GetRequest();

        String text = request.getParameter("param");

        if (text != null)
        {
            Text = text;
        }
    }

    // java bean getters
    public String getText()
    {
        return Text;
    }
}
