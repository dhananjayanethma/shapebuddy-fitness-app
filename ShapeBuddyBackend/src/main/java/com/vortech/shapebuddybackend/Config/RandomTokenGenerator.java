package com.vortech.shapebuddybackend.Config;

import java.util.Random;

public class RandomTokenGenerator {
    private static final int TOKEN_LENGTH = 64;
    private static final String TOKEN_CHARACTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public String generateToken() {
        Random random = new Random();
        StringBuilder token = new StringBuilder();
        for (int i = 0; i < TOKEN_LENGTH; i++) {
            token.append(TOKEN_CHARACTERS.charAt(random.nextInt(TOKEN_CHARACTERS.length())));
        }
        return token.toString();
    }
}