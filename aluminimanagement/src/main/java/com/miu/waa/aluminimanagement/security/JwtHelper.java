package com.miu.waa.aluminimanagement.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import io.jsonwebtoken.*;

@Component
public class JwtHelper {
    @Autowired
    private Environment env;
    private final String secret;
    private final long expiration;

    public JwtHelper(Environment env){
        this.env = env;
        secret = this.env.getProperty("jwt.secret");
        expiration = Long.parseLong(this.env.getProperty("jwt.expiration"));
    }
    public String generateToken(String email, Map<String, Object> claims){

        return Jwts.builder()
                .setClaims(claims) //claim is nothing but header, payload, and signature from the input
                .setSubject(email)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
                .signWith(SignatureAlgorithm.HS256, secret).compact();
    }


    public boolean validateToken(String token){
        try{
            Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token);
            return true;
        }catch (SignatureException e){
            System.out.println(e.getMessage());
        }catch (MalformedJwtException e){
            System.out.println(e.getMessage());
        }catch (ExpiredJwtException e){
            System.out.println(e.getMessage());
        }catch (UnsupportedJwtException e){
            System.out.println(e.getMessage());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public String getUsernameFromToken(String token){
        String result = null;
        if(validateToken(token)){
            result = getSubject(token);
        }
        return  result;
    }

    public String getSubject(String token){
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

}
