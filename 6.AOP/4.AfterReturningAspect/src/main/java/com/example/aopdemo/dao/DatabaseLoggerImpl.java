package com.example.aopdemo.dao;

import com.example.aopdemo.CustomValue;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DatabaseLoggerImpl implements DatabaseLogger {
    @Override
    public List<CustomValue> findValues() {
        List<CustomValue> myValues = new ArrayList<>();

        CustomValue value1 = new CustomValue("ABC");
        CustomValue value2 = new CustomValue("EFO");
        CustomValue value3 = new CustomValue("VER");
        myValues.add(value1);
        myValues.add(value2);
        myValues.add(value3);

        return myValues;
    }
}
