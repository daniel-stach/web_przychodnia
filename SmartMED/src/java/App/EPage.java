package App;

public enum EPage
{
    Register("rejestracja.jsp"),
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
