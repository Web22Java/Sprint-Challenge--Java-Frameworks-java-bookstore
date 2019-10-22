package com.lambdaschool.shelbysprintbookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@EnableWebMvc
@EnableJpaAuditing
@SpringBootApplication
public class ShelbysprintbookstoreApplication
{
    private static boolean stop = false;
    @Autowired
    private static Environment env;
    private static void checkEnvironmentVariable(String envvar)
    {
    }
    public static void main(String[] args)
    {
        checkEnvironmentVariable("OAUTHCLIENTID");
        checkEnvironmentVariable("OAUTHCLIENTSECRET");
        if (!stop)
        {
            ApplicationContext ctx = SpringApplication.run(ShelbysprintbookstoreApplication.class,
                    args);
            DispatcherServlet dispatcherServlet = (DispatcherServlet) ctx.getBean("dispatcherServlet");
            dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
        }
    }
}