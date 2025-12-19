package _5.Dev.Messis.todolist.Filter;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import _5.Dev.Messis.todolist.User.IUserRepository;
import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {
     @Autowired
     private IUserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
                // recebera a requisição apenas se o caminho for /tasks
                var serverletPath = request.getServletPath();
                if(serverletPath.startsWith("/tasks")) {
                    var authorization = request.getHeader("Authorization");
        
        var EncodedPassword = authorization.substring("Basic".length()).trim();
            
        
        byte[] AuthDecoded = Base64.getDecoder().decode(EncodedPassword);
        
        var authString = new String(AuthDecoded);

        String[] credentials = authString.split(":");
        String username = credentials[0];
        String password = credentials[1];

        var user = this.userRepository.findByUsername(username);
        if (user == null) {
            response.sendError(401);
        } else {
                 
        var PasswordVerefication = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
                

                if(PasswordVerefication.verified) {
                    filterChain.doFilter(request, response);
                } else {
                    response.sendError(401);
                }
                }
             }else {
                    filterChain.doFilter(request, response);
                }

        }}



