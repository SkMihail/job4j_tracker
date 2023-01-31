package ru.job4j.early;

public class PasswordValidator {

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (containDeprecate(password)) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }
        char[] chars = password.toCharArray();
        if (chars.length <= 8 || chars.length >= 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        if (hasNoUpperCase(chars)) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (hasNoLowerCase(chars)) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (hasNoDigitCase(chars)) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (hasNoSpecialCase(chars)) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        return password;
    }

    public static boolean hasNoUpperCase(char[] password) {
        for (char ch : password) {
            if (Character.isUpperCase(ch)) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasNoLowerCase(char[] password) {
        for (char ch : password) {
            if (Character.isLowerCase(ch)) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasNoDigitCase(char[] password) {
        for (char ch : password) {
            if (Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasNoSpecialCase(char[] password) {
        for (char ch : password) {
            if (!Character.isLetterOrDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    public static boolean containDeprecate(String password) {
        String[] deprecate = {"qwerty", "12345", "password", "admin", "user" };
        password = password.toLowerCase();
        for (String dep : deprecate) {
            if (password.contains(dep)) {
                return true;
            }
        }
        return false;
    }
}