package App;

public enum EPage
{
    Example("example.jsp"),
    RegisterSucces("rejestracja-zakonczona.jsp"),
    LoginFail("nieloguj.jsp"),
    Reception("recepcja.jsp");

    public final String URL;

    private EPage(String pageURL)
    {
        URL = pageURL;
    }

    public String getPageURL()
    {
        return URL;
    }
}
