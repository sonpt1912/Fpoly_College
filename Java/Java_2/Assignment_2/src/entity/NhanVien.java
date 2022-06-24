/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author son45
 */
public class NhanVien implements Serializable{

    private String maNV;
    private String ten;
    private String ngaySinh;
    private boolean gioitinh;
    private double luong;
    private String chucVu;

    public NhanVien(String maNV, String ten, String ngaySinh, boolean gioitinh, double luong, String chucVu) {
        this.maNV = maNV;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.gioitinh = gioitinh;
        this.luong = luong;
        this.chucVu = chucVu;
    }

    public NhanVien() {
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

  

    public Object[] toShowData() {
        return new Object[]{maNV, ten, ngaySinh, gioitinh ? "Nam" : "Nữ", luong + " đ", chucVu};
    }
}
