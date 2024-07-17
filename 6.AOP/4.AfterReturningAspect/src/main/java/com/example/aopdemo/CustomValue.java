package com.example.aopdemo;

public class CustomValue {
    private String type;

    public CustomValue() {}

    public CustomValue(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "CustomValue{" +
                "type='" + type + '\'' +
                '}';
    }
}
