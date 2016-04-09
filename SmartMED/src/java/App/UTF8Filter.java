package App;

import java.io.IOException;
import javax.servlet.*;

public class UTF8Filter implements Filter
{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        request.setCharacterEncoding("UTF8");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy()
    {
    }
}
