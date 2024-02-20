package com.MedicalSuppliesSystem.MedicalSupplies.utils;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.MedicalSuppliesSystem.MedicalSupplies.pojos.JwtResponse;
import com.MedicalSuppliesSystem.MedicalSupplies.pojos.UserValidPojo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.tomcat.util.codec.binary.Base64;


import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import java.security.Key;
import java.util.Date;

/**
 * @author Rawan.Ahmed
 */
public class JWTUtil {
    public static final String DEFAULT_KEY = "YnZjeGJ2Y3hidmNJTG92ZVNlY3VyaXR5ZmFld29pamV3ZXdxcmV3";
    static SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
    static Base64 base64Url = new Base64(true);
    static Gson gson = new GsonBuilder().create();

    public static String getUsernameFromToken(Claims claims) {
        String userName = claims.getSubject();
        return userName;
    }


    public static byte[] getJwtKey(HttpServletRequest request) {
        return DEFAULT_KEY.getBytes();
    }

    public static String encodeJWT(Object data, byte[] apiKeySecretBytes) {
//        byte[] apiKeySecretBytes = secretKeyString.getBytes();
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        String jwtString = Jwts.builder()
                .claim("data", data)
                .signWith(signatureAlgorithm, signingKey)
                .setIssuedAt(new Date())
                .setExpiration(DateUtilities.addDays(new Date(), 1))
                .compact();
        return jwtString;
    }

    public static String decodeJWT(String jwtString, byte[] secretKeyByte) {
        return decodeJWT(jwtString, secretKeyByte, "data");
    }

    public static String decodeJWT(String jwtString, byte[] secretKeyByte, String claimName) {
        Key signingKey = new SecretKeySpec(secretKeyByte, signatureAlgorithm.getJcaName());
        String string = Jwts.parser()
                .setSigningKey(signingKey)
                .parseClaimsJws(jwtString)
                .getBody()
                .get(claimName, String.class);

        return string;

    }

//    public static boolean checkifMobileService(HttpServletRequest hsr) {
//        return hsr.getRequestURI().contains(ConstantStrings.SUB_MOBILE_URL);
//    }

    public static UserValidPojo getDataToAccess(String result, String key) {
        String[] split_response = result.split("\\.");
        String responseBody = split_response[1];
        String body = new String(base64Url.decode(responseBody));
        JwtResponse jwtObj = gson.fromJson(body, JwtResponse.class); // deserializes json into target2
        return jwtObj.getData();
    }

}



