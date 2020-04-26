package com.test.project.test01.constance;

import lombok.Getter;

@Getter
public enum GenderEnum {
    None("0"),
    Female("1"),
    Male("2");

    //GenderEnum.None.getcode

    private String code;

    GenderEnum(String code) {
        this.code = code;
    }
}
