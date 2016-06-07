package App;

public enum EPage
{
    Register("rejestracja.jsp"),
    Register2("rejestracja2.jsp"),
    Edit("edytuj.jsp"),
    Add("dodaj.jsp"),
    RegisterSucces("rejestracja-zakonczona.jsp"),
    LoginFail("nieloguj.jsp"),
    Reception("recepcja.jsp"),
    LROOM("lekarz.jsp");

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
