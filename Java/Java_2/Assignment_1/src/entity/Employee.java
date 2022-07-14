/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package entity;

import java.io.Serializable;

/**
 *
 * @author son45
 */
public class Employee implements Serializable{


    private String maNV;
    private String name;
    private int age;
    private String email;
    private int luong;

    public Employee(String maNV, String name, int age, String email, int luong) {
        this.maNV = maNV;
        this.name = name;
        this.age = age;
        this.email = email;
        this.luong = luong;
    }

    public Employee() {
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }

  

    public Object[] toDataRow() {
        return new Object[]{maNV, name, age, email, luong};
    }

}
