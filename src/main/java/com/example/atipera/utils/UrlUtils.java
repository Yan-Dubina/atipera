package com.example.atipera.utils;

import com.example.atipera.enums.Postfix;

public class UrlUtils {

    public static final String REPO_URL_TEMPLATE = "https://api.github.com/users/{username}/repos";

    public static String removePostfixFromUrls(String url, Postfix postfix) {
        return url.replace(postfix.value, "");
    }
}
