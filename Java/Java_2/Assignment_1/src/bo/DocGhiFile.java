/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package bo;

import entity.Employee;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author son45
 */
public class DocGhiFile {

    public String ghiFile(String path, List<Employee> listGhi) {

        try {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Employee em : listGhi) {
                oos.writeObject(em);
            }
            oos.close();
            fos.close();
            return "ghi file thành công";
        } catch (IOException ex) {
            Logger.getLogger(DocGhiFile.class.getName()).log(Level.SEVERE, null, ex);
            return "ghi file không thành công";
        }

    }

    public String docFile(String path, List<Employee> listDoc) {

        try {
            File file = new File(path);
            if (!file.exists()) {
                return "file không tồn tại";
            }
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Employee list = new Employee();
            while (fis.available() > 0) {
                list = (Employee) ois.readObject();
                listDoc.add(list);
            }
            ois.close();
            fis.close();
            return "đọc file thành công";
        } catch (Exception ex) {
            Logger.getLogger(DocGhiFile.class.getName()).log(Level.SEVERE, null, ex);
            return "đọc file không thành công";
        }
    }
}
