package com.malexj.app.controller;

import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class ControllerTest {

    @Test
    public void test(){

        String n1 = "2000";
        String n2 = "20000";
        String n3 = "200000";
        String n4 = "400000";
        String n5 = "50000";
        String n6 = "800";
        String n7 = "8000";

        Set<String> strs = new TreeSet<>();
        strs.add(n6);
        strs.add(n7);
        strs.add(n3);
        strs.add(n4);
        strs.add(n1);
        strs.add(n2);
        strs.add(n5);

        System.out.println(strs);

    }

}
