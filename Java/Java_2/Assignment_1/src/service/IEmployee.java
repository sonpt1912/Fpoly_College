/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import entity.Employee;
import java.util.List;

/**
 *
 * @author son45
 */
public interface IEmployee {

    void loadData(List<Employee> list);

    List<Employee> findByID(List<Employee> find, String id);
    
    boolean removeByRow(List<Employee> listRemove, int index);

    boolean updateByRow(List<Employee> listUpdate, int index, Employee em);

}
