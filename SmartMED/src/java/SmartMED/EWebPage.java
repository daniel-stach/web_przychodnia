package SmartMED;

public enum EWebPage
{
    Example("example.jsp"),
    RegisterSucces("rejestracja-zakonczona.jsp");

    public final String PageURL;

    private EWebPage(String pageURL)
    {
        PageURL = pageURL;
    }

    public String getPageURL()
    {
        return PageURL;
    }
}
