package com.demo.admin.interceptor;

import com.demo.admin.util.Passport;
import org.apache.commons.io.IOUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * WebFilter
 *
 * @author ybtccc ,2019/2/27
 */
@Component
@javax.servlet.annotation.WebFilter(urlPatterns = "/**")
@Order(1)
public class WebFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ServletRequest requestWrapper = null;
        if(request instanceof HttpServletRequest) {
            requestWrapper = new RequestReaderHttpServletRequestWrapper((HttpServletRequest) request);
        }
        if(requestWrapper == null) {
            chain.doFilter(request, response);
        } else {
            chain.doFilter(requestWrapper, response);
        }
    }

    @Override
    public void destroy() {

    }
    class WrapServletInputStream extends ServletInputStream {

        private ByteArrayInputStream byteArrayInputStream;

        public WrapServletInputStream(ByteArrayInputStream byteArrayInputStream) {
            this.byteArrayInputStream = byteArrayInputStream;
        }

        @Override
        public boolean isFinished() {
            return byteArrayInputStream.available() == 0;
        }

        @Override
        public boolean isReady() {
            return true;
        }

        @Override
        public void setReadListener(ReadListener readListener) {

        }

        @Override
        public int read() throws IOException {
            return byteArrayInputStream.read();
        }
    }

    class RequestReaderHttpServletRequestWrapper extends HttpServletRequestWrapper {

        public RequestReaderHttpServletRequestWrapper(HttpServletRequest request) {
            super(request);
            try {
                String body = IOUtils.toString(request.getInputStream(),"utf-8");
                Passport passport = new Passport();
                passport.setRequestBody(body);
                Passport.threadLocal.set(passport);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public ServletInputStream getInputStream() throws IOException {
            Passport passport = Passport.threadLocal.get();
            return new WrapServletInputStream((ByteArrayInputStream) IOUtils.toInputStream(passport.getRequestBody()));
        }
    }
}
