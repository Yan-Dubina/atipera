package com.example.atipera.enums;

import lombok.Getter;

@Getter
public enum Postfix {

    Branch("{/branch}");


    public final String value;

    Postfix(String value) {
        this.value = value;
    }

}
