package com.scooty.scooty.services;

import com.scooty.scooty.model.AuthenticatedUser;
import com.scooty.scooty.model.UserWithAuthentication;
import com.scooty.scooty.table.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class EmailAuthenticationProvider implements AuthenticationProvider {

    private final UsersService usersService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
       String password = authentication.getCredentials().toString();
        User user = usersService.getUserByEmail(email);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        if (user.isDeleted()) {
            throw new ResponseStatusException(HttpStatus.LOCKED);
        }
        if (user.getPassword().equals(password)) {
            AuthenticatedUser authenticatedUser = new AuthenticatedUser(
                    user.getId(),
                    user.getEmail(),
                    user.getFirstName(),
                    user.getLastName()
            );

            Set<GrantedAuthority> authorities = new HashSet<>();
            authorities.add(new SimpleGrantedAuthority("defaultRole"));

            UserWithAuthentication userWithAuthentication = new UserWithAuthentication(authenticatedUser, authorities);
            return userWithAuthentication;
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
       }

    }


    @Override
    public boolean supports(Class<?> aClass) {
        return (UsernamePasswordAuthenticationToken.class
                .isAssignableFrom(aClass));
    }
}
