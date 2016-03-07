package SmartMED;

public class Controller extends WebApp.AppController
{
    private EWebPage ResultPage;
    protected AppSession ParentSession;

    public void SetParentSession(AppSession parentSession)
    {
        ParentSession = parentSession;
    }

    public AppSession GetParentSession()
    {
        return ParentSession;
    }

    public Object GetSessionBean(String beanName)
    {
        return ParentSession.getSessionBean(beanName);
    }

    public void SetSessionBean(String beanName, Object object)
    {
        ParentSession.setSessionBean(beanName, object);
    }

    public String GetAppLink(EAppOperation operation)
    {
        return "App?" + EAppOperation.OperationParamName + "=" + operation.OperationCode;
    }

    private void SetResultPage(EWebPage resultPage)
    {
        ResultPage = resultPage;
    }

    public EWebPage GetResultPage()
    {
        return ResultPage;
    }

    public void ProcessRequest()
    {
        SetResultPage(null);
        String opCode = CurrentRequest.getParameter("op");
        EAppOperation operation = EAppOperation.ParseString(opCode);

        switch (operation)
        {
            case Example:
                ProcessExample();
                break;
            case Login:
                ProcessLogin();
                break;
            default:
                SetResultPage(EWebPage.NotFound);
        }
    }

    private void ProcessExample()
    {
        Example example = (Example) GetSessionBean("example");
        if (example == null)
        {
            example = new Example();
            SetSessionBean("example", example);
        }
        example.Generate(this);

        SetResultPage(EWebPage.Example);
    }

    private void ProcessLogin()
    {
        // TODO: implement a login system
        String email = CurrentRequest.getParameter("email");
        String password = CurrentRequest.getParameter("password");
        System.out.println(email);
        System.out.println(password);

        ProcessExample();
    }
}
