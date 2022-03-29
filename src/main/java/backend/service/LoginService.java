package backend.service;
import backend.controller.LoginController;
import backend.model.User;
import backend.repo.UserRepo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class LoginService {

    UserRepo userRepo;

    LoginService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public static String keyStr = "testsecrettestsecrettestsecrettestsecrettestsecret";

    private static final Logger LOGGER = LogManager.getLogger(LoginController.class);

    public String loginUser(String username, String password) {
        // check username and password are valid to access token
        // note that subsequent request to the API need this token

        User foundUser = userRepo.findByUsername(username);

        if(foundUser != null) {
            if (Objects.equals(foundUser.getPassword(), password)) {
                LOGGER.info("USER LOGGED IN - " + username);
                return generateToken(username);
            } else {
                return "Wrong password";
            }
        }
        return "User not found";
    }

    public String generateToken(String userId){
        Key key = Keys.hmacShaKeyFor(keyStr.getBytes(StandardCharsets.UTF_8));
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

        Claims claims = Jwts.claims().setSubject(userId);
        claims.put("userId", userId);
        claims.put("authorities", grantedAuthorities
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList()));

        return Jwts.builder()
                .setId(UUID.randomUUID().toString())
                .setSubject(userId)
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000000))
                .signWith(key)
                .compact();
    }


}
