package com.example.beelan.interInvest.supports;

public class DepositComponentsList {
    private int id;
    private String key;
    private String value1;
    private String value2;
    private String value3;

    public DepositComponentsList(int id, String key, String value1, String value2, String value3) {
        this.id = id;
        this.key = key;
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public String getValue3() {
        return value3;
    }

    public void setValue3(String value3) {
        this.value3 = value3;
    }


}
