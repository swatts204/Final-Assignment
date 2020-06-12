package org.launchcode.demo;

import org.launchcode.demo.controllers.AuthenticationController;
import org.launchcode.demo.models.User;
import org.launchcode.demo.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AuthenticationFilter extends HandlerInterceptorAdapter {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationController authenticationController;

    private static final List<String> whitelist = Arrays.asList("/login","register","/logout","sneakers/add","/js/bootstrap");

    private static boolean isWhitelisted(String path) {
        for (String pathRoot: whitelist){
            if (path.startsWith(pathRoot)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws IOException {

        if (isWhitelisted(request.getRequestURI())) {

            return true;
        }
        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);


        if (user != null) {
//            if(request.getRequestURI().equals("sneakers/add") && !user.getRole().equals("admin")){
//                response.sendRedirect("/login");
//                return false;
//            }
            return true;
        }


        response.sendRedirect("/login");
        return false;
    }




}
