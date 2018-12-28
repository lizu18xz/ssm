package com.fayayo.pojo;

public enum SexEnum {

    MALE(1, "男"),
    FEMALE(0, "女");

    private int code;
    private String name;

    SexEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 根据code获取性别枚举
     * @param code 编号
     * @return 性别枚举
     */
    public static SexEnum getSexByCode(int code) {
        for(SexEnum sex : SexEnum.values()) {
            if (sex.getCode() == code) {
                return sex;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
