package com.collaroid.test;

import java.io.*;

/**
 * Created by Frank on 10/12/15.
 */
public class CloneTest {

    public static void main(String[] args) {
        User user1 = new User(1, new Stu("robin", 22));
        try {
            User user2 = deepClone(user1);
            user1.getStu().setName("jack");
            System.out.println(user1);
            System.out.println(user2);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T deepClone(T obj){
        T cloneObj = null;
        try {
            //写入字节流
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream obs = new ObjectOutputStream(out);
            obs.writeObject(obj);
            obs.close();

            //分配内存，写入原始对象，生成新对象
            ByteArrayInputStream ios = new ByteArrayInputStream(out.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(ios);
            //返回生成的新对象
            cloneObj = (T) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cloneObj;
    }
}


class User implements Cloneable, Serializable{
    int id;
    Stu stu;

    public User(int id, Stu stu) {
        this.id = id;
        this.stu = stu;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", stu=" + stu +
                '}' + "\n" + super.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Stu getStu() {
        return stu;
    }

    public void setStu(Stu stu) {
        this.stu = stu;
    }

    @Override
    protected User clone() throws CloneNotSupportedException {
        User cloneUser = (User)super.clone();
        cloneUser.setStu(cloneUser.getStu().clone());
        return cloneUser;
    }
}

class Stu implements Cloneable, Serializable {
    String name;
    int age;

    public Stu(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}'+ "\n" + super.toString();
    }

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

    @Override
    protected Stu clone() throws CloneNotSupportedException {
        return (Stu)super.clone();
    }
}