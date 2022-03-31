package backend.service;

import backend.model.Role;
import backend.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

public interface UserService {

    List<SimpleGrantedAuthority> getAuthorities(User user);

    Collection<? extends GrantedAuthority> getAuthorities();

    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
