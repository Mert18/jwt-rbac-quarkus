package org.hachiko.shopping.jwt;

import io.smallrye.jwt.build.Jwt;

import javax.inject.Singleton;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Singleton
public class JwtService {
    public String generateJwt(){
        Set<String> roles = new HashSet<>(
                Arrays.asList("admin", "user")
        );
        long duration = System.currentTimeMillis() + 3600;
        return Jwt.issuer("shopping-jwt").subject("shopping-jwt").groups(roles).expiresAt(duration).sign();
    }
}
