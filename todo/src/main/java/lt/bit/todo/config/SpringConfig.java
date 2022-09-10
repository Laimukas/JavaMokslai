package lt.bit.todo.config;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class SpringConfig {
    
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new Argon2PasswordEncoder();
//        return new PasswordEncoder() {
//            PasswordEncoder pe = new Argon2PasswordEncoder();
//            @Override
//            public String encode(CharSequence rawPassword) {
//                System.out.println("encoding");
//                System.out.println(rawPassword);
//                String encoded = pe.encode(rawPassword);
//                System.out.println(encoded);
//                return encoded;
//            }
//
//            @Override
//            public boolean matches(CharSequence rawPassword, String encodedPassword) {
//                System.out.println("Does it match");
//                System.out.println(rawPassword);
//                System.out.println(encodedPassword);
//                boolean ok = pe.matches(rawPassword, encodedPassword);
//                System.out.println(ok);
//                return ok;
//            }
//        };
    }

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
    
    @Bean
    public AuthenticationSuccessHandler loggedIn() {
        AuthenticationSuccessHandler h = new AuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth) throws IOException, ServletException {
                MyUserDetails ud = (MyUserDetails) auth.getPrincipal();
                System.out.println(ud.getUsername() + " prisijunge sekmingai");
                response.sendRedirect("./todo");
            }
        };
        return h;
    }

}
