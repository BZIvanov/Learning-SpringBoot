package com.example.aopdemo.dao;

import com.example.aopdemo.CustomValue;
import org.springframework.stereotype.Repository;

@Repository
public class DatabaseLoggerImpl implements DatabaseLogger {
    @Override
    public void addUser() {
        System.out.println(getClass().getName() + ": ADDED USER TO DB");
    }

    @Override
    public void addProduct() {
        System.out.println(getClass().getName() + ": ADDED PRODUCT TO DB");
    }

    @Override
    public int addSum(int a, int b) {
        System.out.println(getClass().getName() + ": ADDED SUM TO DB");

        return a + b;
    }

    @Override
    public void addCustomValue(CustomValue customValue) {
        System.out.println(getClass() + ": ADDED CUSTOM VALUE " + customValue.getType());
    }

    @Override
    public void addCustomValue(CustomValue customValue, int quantity) {
        System.out.println(getClass() + ": ADDED CUSTOM VALUE " + customValue.getType() + " - " + quantity);
    }
}
