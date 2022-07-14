/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package service.impl;

import entity.Employee;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author son45
 */
public class EmployeeService implements service.IEmployee {

    @Override
    public List<Employee> findByID(List<Employee> find, String id) {
        List<Employee> listNhanVien = new ArrayList<>();
        int size = find.size();
        for (int i = 0; i < size; i++) {
            if (find.get(i).getMaNV().contains(id)) {
                listNhanVien.add(find.get(i));
            }
        }
        return listNhanVien;

    }

    @Override
    public boolean updateByRow(List<Employee> listUpdate, int index, Employee em) {
        boolean check = false;
        int size = listUpdate.size();
        for (int i = 0; i < size; i++) {
            if (i == index) {
                listUpdate.set(index, em);
            }
        }
        return check;
    }

    @Override
    public void loadData(List<Employee> list) {
        list.add(new Employee("nv1", "trần nam tuấn", 19, "trannamtuan@gmail.com", 3000));
        list.add(new Employee("nv2", "phạm gia bảo", 27, "phamgiabao@gmail.com", 3000));
        list.add(new Employee("nv3", "đăng thanh hà", 24, "dangthanhha@gmail.com", 3000));
        list.add(new Employee("nv4", "nguyễn hàng sính", 52, "nguyhsinh@gmail.com", 3000));
    }

    @Override
    public boolean removeByRow(List<Employee> listRemove, int index) {
        boolean check = false;
        int size = listRemove.size();
        for (int i = 0; i < size; i++) {
            if (i == index) {
                listRemove.remove(i);
                check = true;
            }
        }
        return check;
    }
}
