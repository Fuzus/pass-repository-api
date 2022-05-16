package br.com.fuzusnoary.passrepositoryapi.utils;

import org.springframework.security.core.token.Sha512DigestUtils;

public class TokenUtils {
    public static String createToken(String str) {
        return Sha512DigestUtils.shaHex(str);
    }

    public static String shuffle(String str, String shuffler) {
        StringBuilder result = new StringBuilder();
        int emailIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            result.append(str.charAt(i));
            result.append(shuffler.charAt(emailIndex));
            emailIndex++;
            if (emailIndex == shuffler.length()) {
                emailIndex = 0;
            }
        }
        return result.toString();
    }
}
