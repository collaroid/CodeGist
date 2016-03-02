package com.collaroid.test;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializerProvider;

import java.io.IOException;

/**
 * Created by Frank on 10/10/15.
 */
public class JacksonTest {

    public static void main(String args[]){

//        Student student = new Student();
//        student.setAge(22);
//        student.setName("robin");
//
//        try {
//            Method m1 = student.getClass().getMethod("setName", String.class);
//            m1.invoke(student, new Object[]{null});
//            System.out.println(student);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//
//        ObjectMapper mapper = new ObjectMapper();
//        String jsonString = "";
//
//        try{
//            Student student = new Student();
//            student.setAge(22);
//            student.setName("robin");
//
//            mapper.enable(SerializationConfig.Feature.INDENT_OUTPUT);
//            SimpleModule module = new SimpleModule("qq", new Version(1,1,1,"a"));
//            module.addSerializer(Student.class, new StuASerialier());
//            mapper.registerModule(module);
//
//            jsonString = mapper.writeValueAsString(student);
//
//            System.out.println(jsonString);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        ObjectMapper mapper = new ObjectMapper();
        Student student = new Student();
        student.setName("robin");
        student.setAge(22);
        student.setBirthDay("1990");

        Person person = student;
        String jsonString = "";
        try {
            jsonString = mapper.writeValueAsString(person);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(jsonString);
    }

}

class StuASerialier extends JsonSerializer<Student> {

    @Override
    public void serialize(Student student, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
//
//        jsonGenerator.writeStartObject();
//        jsonGenerator.writeNumberField("id", 123);
//        jsonGenerator.writeStringField("itemName", "test");
//        jsonGenerator.writeEndObject();

    }
}

class Person{
    protected String birthDay;

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }
}

class Student extends Person{
    private String name;
    private int age;

    public Student(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public String toString(){
        return "Student [ name: "+name+", age: "+ age+ ", birthday: "+ super.birthDay+" ]";
    }
}