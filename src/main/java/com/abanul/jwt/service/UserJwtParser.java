package com.abanul.jwt.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;

@Service
public class UserJwtParser {

    public Claims parseJwtToken(String jwtToken){
        return Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary("secret"))
                .parseClaimsJws(jwtToken).getBody();
    }
}
