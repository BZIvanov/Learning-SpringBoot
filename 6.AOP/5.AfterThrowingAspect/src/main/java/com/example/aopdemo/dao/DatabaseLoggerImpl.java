package com.example.aopdemo.dao;

import com.example.aopdemo.CustomValue;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DatabaseLoggerImpl implements DatabaseLogger {
    @Override
    public List<CustomValue> findValues(boolean shouldThrow) {
        if (shouldThrow) {
            throw new RuntimeException("MY INTENTIONAL ERROR");
        }

        List<CustomValue> myValues = new ArrayList<>();
        CustomValue value1 = new CustomValue("ABC");
        myValues.add(value1);

        return myValues;
    }
}
