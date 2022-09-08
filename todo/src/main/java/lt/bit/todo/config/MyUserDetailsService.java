package lt.bit.todo.config;

import java.util.List;
import lt.bit.todo.dao.UsersDAO;
import lt.bit.todo.data.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersDAO usersDAO;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Users> list = usersDAO.byName(username);
        if (list.isEmpty()) {
            throw new UsernameNotFoundException(username + " not found");
        }
        Users u = list.get(0);
        return new MyUserDetails(u);
    }
    
}
