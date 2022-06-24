/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.NhanVien;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.stream.FileImageInputStream;

/**
 *
 * @author son45
 */
public class docGhiFile {

    public String ghiFile(String path, List<NhanVien> list) {

        try {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (NhanVien nv : list) {
                oos.writeObject(nv);
            }
            return "ghi thành công";
        } catch (IOException ex) {
            Logger.getLogger(docGhiFile.class.getName()).log(Level.SEVERE, null, ex);
            return "ghi không thành công";
        }

    }

    public String docFile(String path, List<NhanVien> list) {

        try {
            File file = new File(path);
            if (!file.exists()) {
                return "file không tồn tại";
            }
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            NhanVien nv = new NhanVien();
            while (fis.available() > 0) {
                nv = (NhanVien) ois.readObject();
                list.add(nv);
            }
            return "đọc thành công";
        } catch (Exception ex) {
            Logger.getLogger(docGhiFile.class.getName()).log(Level.SEVERE, null, ex);
            return "ghi đọc thành công";
        }

    }
}
