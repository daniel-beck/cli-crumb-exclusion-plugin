package org.jenkinsci.plugins.clicrumbexclusion;

import hudson.Extension;
import hudson.security.csrf.CrumbExclusion;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Extension
public class CliCrumbExclusion extends CrumbExclusion {
    @Override
    public boolean process(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String pathInfo = request.getPathInfo();
        if (pathInfo != null && "/cli".equals(pathInfo)) {
            chain.doFilter(request, response);
            return true;
        }
        return false;
    }
}