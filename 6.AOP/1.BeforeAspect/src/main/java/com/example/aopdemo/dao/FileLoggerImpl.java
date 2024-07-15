package com.example.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class FileLoggerImpl implements FileLogger {
    @Override
    public void addUser() {
        System.out.println(getClass().getName() + ": ADDED USER TO FILE");
    }
}
