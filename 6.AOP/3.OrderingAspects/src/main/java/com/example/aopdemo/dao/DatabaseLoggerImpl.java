package com.example.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class DatabaseLoggerImpl implements DatabaseLogger {
    private String prefix;

    @Override
    public void addUser() {
        System.out.println(getClass().getName() + ": ADDED USER TO DB");
    }

    public String getPrefix() {
        System.out.println("GETTER Prefix");
        return prefix;
    }

    public void setPrefix(String prefix) {
        System.out.println("SETTER Prefix");
        this.prefix = prefix;
    }
}
