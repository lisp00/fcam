package kr.co.fastcampus.web;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Slf4j
public class SimpleFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        log.info("Filter - Hello World");
        HttpSession session = ((HttpServletRequest) request).getSession();
        String username = (String) session.getAttribute("username");
        if(username == null) {
            log.info("new user");
            session.setAttribute("username", "jojo");
        } else {
            log.info("user ->" + username);
        }

        chain.doFilter(request, response);
        var writer = response.getWriter();
        writer.print("filter - Hello world!!!");
    }
}
