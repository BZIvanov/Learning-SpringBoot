package com.example.aopdemo.dao;

import com.example.aopdemo.CustomValue;

import java.util.List;

public interface DatabaseLogger {
    List<CustomValue> findValues(boolean shouldThrow);
}
