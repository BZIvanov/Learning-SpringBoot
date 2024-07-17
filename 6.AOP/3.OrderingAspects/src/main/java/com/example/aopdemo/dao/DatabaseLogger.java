package com.example.aopdemo.dao;

public interface DatabaseLogger {
    void addUser();

    String getPrefix();

    void setPrefix(String prefix);
}
