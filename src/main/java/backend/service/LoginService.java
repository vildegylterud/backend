package backend.service;
import backend.controller.LoginController;
import backend.model.Role;
import backend.model.User;
import backend.repo.RoleRepo;
import backend.repo.UserRepo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class LoginService {
    UserRepo userRepo;
    RoleRepo roleRepo;
    PasswordEncoder passwordEncoder;

    LoginService(UserRepo userRepo) {
        this.userRepo = userRepo;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public static String keyStr = "testsecrettestsecrettestsecrettestsecrettestsecret";

    private static final Logger LOGGER = LogManager.getLogger(LoginController.class);

    public String loginUser(String username, String password) {
        // check username and password are valid to access token
        // note that subsequent request to the API need this token

        User foundUser = userRepo.findByUsername(username);
        Optional<Role> foundRole = roleRepo.findById(foundUser.getId());
        String encodedPassword = passwordEncoder.encode(password);
        String encodedDatabasePassword = passwordEncoder.encode(foundUser.getPassword());
        boolean matches = passwordEncoder.matches(foundUser.getPassword(), encodedPassword);
        if (matches) {
            if (Objects.equals(foundUser.getPassword(), password)) {
                LOGGER.info("USER LOGGED IN - " + username);

                LOGGER.info(encodedPassword);
                LOGGER.info(encodedDatabasePassword);
                return generateToken(username, foundRole.toString());
            } else {
                return "Wrong password";
            }
        }
        return "User not found";
    }

    public String generateToken(String userId,String roleId) {
        Key key = Keys.hmacShaKeyFor(keyStr.getBytes(StandardCharsets.UTF_8));
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

        Claims claims = Jwts.claims().setSubject(userId).setSubject(roleId);
        claims.put("userId", userId);
        claims.put("role_id", roleId);
        claims.put("authorities", grantedAuthorities
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList()));

        return Jwts.builder()
                .setId(UUID.randomUUID().toString())
                .setSubject(userId)
                .setSubject(roleId)
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000000))
                .signWith(key)
                .compact();
    }



    public User saveUser(User newUser) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode(newUser.getPassword());
        newUser.setPassword(encode);
        User user = userRepo.save(newUser);
        return user;
    }
}