package api;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;


public class RestCorsFilter implements Filter {

    @Override
    public void destroy() {
        //enter code here
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletResponse resp = (HttpServletResponse) response;
        resp.addHeader("access-control-allow-origin", "*");
        resp.addHeader("access-control-allow-headers", "*");
        resp.addHeader("access-control-allow-methods", "*");
        resp.addHeader("access-control-allow-credentials", "true");
        resp.addHeader("access-control-expose-headers", "Location");


        chain.doFilter(request, resp);

    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }

}