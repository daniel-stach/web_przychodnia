package SmartMED;

import javax.servlet.http.*;
import java.util.*;

public class AppSession
{
    HttpSession Session;
    Date LoginTime;
    String ClientIP;

    Controller Controller;

    private boolean LoggedIn = false;

    public AppSession()
    {
        Controller = new Controller();
        Controller.SetParentSession(this);
    }

    public HttpSession getHttpSession()
    {
        return Session;
    }

    public void setHttpSession(HttpSession session)
    {
        Session = session;
    }

    public Object getSessionBean(String beanName)
    {
        return Session.getAttribute(beanName);
    }

    public void setSessionBean(String beanName, Object object)
    {
        Session.setAttribute(beanName, object);
    }

    public boolean isLoggedIn()
    {
        return LoggedIn;
    }

    public void LogOut()
    {
        LoggedIn = false;
        Session.invalidate();
        Controller = new Controller();     // reset controller
    }

    public String getSessionID()
    {
        return Session.getId();
    }

    public Date getLoginTime()
    {
        return LoginTime;
    }

    public void setLoginTime(Date LoginTime)
    {
        this.LoginTime = LoginTime;
    }

    public Date getLastOperationTime()
    {
        if (!LoggedIn)
        {
            return null;
        }
        return new Date(Session.getLastAccessedTime());
    }

    public String getClientIP()
    {
        return ClientIP;
    }

    public void setClientIP(String ip)
    {
        ClientIP = ip;
    }

    public Controller GetController()
    {
        return Controller;
    }
}
