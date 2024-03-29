package lt.bit.todo.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lt.bit.todo.data.Permissions;
import lt.bit.todo.data.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails {
    
    private final Users user;
    
    public MyUserDetails(Users user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList();
        for (Permissions permissions : this.user.getPermissionsList()) {
            list.add(new SimpleGrantedAuthority(permissions.getPermissionName()));
        }
        return list;
    }
    
    public Users getUser() {
        return this.user;
    }

    @Override
    public String getPassword() {
        return this.user.getUserPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
}
