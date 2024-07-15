package com.example.aopdemo.dao;

import com.example.aopdemo.CustomValue;

public interface DatabaseLogger {
    void addUser();

    void addProduct();

    int addSum(int a, int b);

    void addCustomValue(CustomValue customValue);

    void addCustomValue(CustomValue customValue, int quantity);
}
