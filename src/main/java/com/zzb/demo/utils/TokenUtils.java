package com.zzb.demo.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtils {

    public static final String SECRECT = "asdf123456";

    public static String createToken() {
        Algorithm algorithm = Algorithm.HMAC256(SECRECT);

        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");

        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();

        calendar.add(Calendar.DATE, 7);
        Date expireDate = calendar.getTime();

        String token = JWT.create()
                .withHeader(map)
                .withIssuer("SERVICE")
                .withSubject("Test token")
                .withAudience("APP")
                .withClaim("userId", "1")
                .withIssuedAt(currentDate)
                .withExpiresAt(expireDate)
                .sign(algorithm);

        return token;
    }

    public static String verifyToken(final String token) {
        Algorithm algorithm = Algorithm.HMAC256(SECRECT);
        JWTVerifier jwtVerifier = JWT.require(algorithm)
                .withIssuer("SERVICE")
                .build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);

        String userId = decodedJWT.getClaim("userId").asString();

        return userId;
    }
}
