package backend.service;

import backend.model.Role;
import backend.model.User;
import backend.repo.RoleRepo;
import backend.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Service @RequiredArgsConstructor
@Transactional @Slf4j
public class UserServiceImpl implements UserService{

    UserRepo userRepo;
    RoleRepo roleRepo;
    User user;

    @Override
    public List<SimpleGrantedAuthority> getAuthorities(User user) {

     Set<Role> roles = user.getRoles();
     List<SimpleGrantedAuthority>  authorities = new ArrayList<>();

     for (Role role : roles) {
         authorities.add(new SimpleGrantedAuthority(role.getName()));
     }
     return authorities;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Set<Role> roles = user.getRoles();
        List<SimpleGrantedAuthority>  authorities = new ArrayList<>();

        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }


    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = userRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);

        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }


}
