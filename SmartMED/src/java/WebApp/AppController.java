package WebApp;

public class AppController
{
    protected javax.servlet.http.HttpServletRequest CurrentRequest;

    public javax.servlet.http.HttpServletRequest GetCurrentRequest()
    {
        return CurrentRequest;
    }

    public void BeginRequest(javax.servlet.http.HttpServletRequest request)
    {
        CurrentRequest = request;
    }

    public void EndRequest()
    {
        CurrentRequest = null;
    }
}
