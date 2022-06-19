/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assigmentmau;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author son45
 */
public class service {

    public void UpdateByRow(List<NhanVien> list, int index, NhanVien nv) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i == index) {
                list.set(index, nv);
            }
        }
    }

    public void removeByRow(List<NhanVien> list, int index) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i == index) {
                list.remove(i);
            }
        }
    }

    public List<NhanVien> findByMa(List<NhanVien> list, String ma) {
        int size = list.size();
        List<NhanVien> listf = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (list.get(i).getMaNV().contains(ma)) {
                listf.add(list.get(i));
            }
        }
        return listf;
    }

    public void sortByTen(List<NhanVien> list, String text) {
        if (text.equalsIgnoreCase("Tăng dần")) {
            list.sort((o1, o2) -> {
                return o1.getTen().compareTo(o2.getTen());
            });
        } else {
            list.sort((o1, o2) -> {
                return o2.getTen().compareTo(o1.getTen());
            });
        }
    }

    public void sortByMa(List<NhanVien> list, String text) {
        if (text.equalsIgnoreCase("tăng dần")) {
            list.sort((o1, o2) -> {
                return o1.getMaNV().compareTo(o2.getMaNV());
            });
        } else {
            list.sort((o1, o2) -> {
                return o2.getMaNV().compareTo(o1.getMaNV());
            });
        }
    }

    public void sortByNgaySinh(List<NhanVien> list, String text) {
//        if (text.equalsIgnoreCase("tăng dần")) {
//            list.sort((o1, o2) -> {
//                return o1.getNgaySinh() - o2.getNgaySinh();
//            });
//        } else {
//            list.sort((o1, o2) -> {
//                return o2.getNgaySinh() - o1.getNgaySinh();
//            });
//        }
    }

    public void sortByLuong(List<NhanVien> list, String text) {
        
        if (text.equalsIgnoreCase("tăng dần")) {
            list.sort((o1, o2) -> {
                return  (int) (o1.getLuong() - o2.getLuong());
            });
        } else {
            list.sort((o1, o2) -> {
                return (int) (o2.getLuong() - o1.getLuong());
            });
        }
    }
}
