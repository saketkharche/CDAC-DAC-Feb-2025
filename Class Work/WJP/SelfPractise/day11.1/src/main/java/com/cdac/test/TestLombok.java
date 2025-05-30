package com.cdac.test;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
class TestLombok {
    private String name;
    private int age;

    public static void main(String[] args) {
        TestLombok obj = new TestLombok();
        obj.setName("Saket");
        obj.setAge(25);
        System.out.println(obj.getName());
    }
}