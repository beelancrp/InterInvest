package com.example.beelan.fiveten.supports;


public class FragmentComponentsList {

    private int id;
    private String title;
    private String value;

    public FragmentComponentsList(int id, String title, String value) {
        this.id = id;
        this.title = title;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
