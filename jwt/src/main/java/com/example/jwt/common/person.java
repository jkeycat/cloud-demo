package com.example.jwt.common;

class Person {
    private  String  user;
    private  String  age;
    private  String  sex;
    public  static  Person  getPerson(String user,String age,String sex){
        Person person = new Person();
        person.age=age;
        person.sex=sex;
        person.user=user;
        return  person;
    }
}



