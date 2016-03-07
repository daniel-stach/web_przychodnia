package WebApp;

import javax.servlet.http.*;

public class SessionListener implements HttpSessionListener
{
    @Override
    public void sessionCreated(HttpSessionEvent e)
    {
        HttpSession session = e.getSession();
        SmartMED.AppSession appSession = new SmartMED.AppSession();
        appSession.setHttpSession(session);
        session.setAttribute("appSession", appSession);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent e)
    {
    }
}
