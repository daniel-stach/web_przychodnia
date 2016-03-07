package SmartMED;

public class Example
{
    private String Text = "Elo520";

    public void Generate(Controller controller)
    {
        javax.servlet.http.HttpServletRequest request = controller.GetCurrentRequest();

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
