package com.dai.model;

import com.dai.swing.table.ModelAction;
import com.dai.swing.table.EventAction.EventActionNguoiMua;

/**
 *
 * @author dainguyen
 */
public class Model_Khach_Hang {

    /**
     * @return the Gioi_Tinh
     */
    public String getGioi_Tinh() {
        return Gioi_Tinh;
    }

    /**
     * @param Gioi_Tinh the Gioi_Tinh to set
     */
    public void setGioi_Tinh(String Gioi_Tinh) {
        this.Gioi_Tinh = Gioi_Tinh;
    }

    /**
     * @return the Ngay_Sinh
     */
    public String getNgay_Sinh() {
        return Ngay_Sinh;
    }

    /**
     * @param Ngay_Sinh the Ngay_Sinh to set
     */
    public void setNgay_Sinh(String Ngay_Sinh) {
        this.Ngay_Sinh = Ngay_Sinh;
    }

    private String Ma_Khach_Hang;
    private String Ho_Ten;
    private String So_Dien_Thoai;
    private String Email;
    private String Gioi_Tinh;
    private String Ngay_Sinh;
    private String Dia_Chi;
    private String Trang_Thai;
    private String Ngay_Tao;

    public String getMa_Khach_Hang() {
        return Ma_Khach_Hang;
    }

    public void setMa_Khach_Hang(String Ma_Khach_Hang) {
        this.Ma_Khach_Hang = Ma_Khach_Hang;
    }

    public String getHo_Ten() {
        return Ho_Ten;
    }

    public void setHo_Ten(String Ho_Ten) {
        this.Ho_Ten = Ho_Ten;
    }

    public String getSo_Dien_Thoai() {
        return So_Dien_Thoai;
    }

    public void setSo_Dien_Thoai(String So_Dien_Thoai) {
        this.So_Dien_Thoai = So_Dien_Thoai;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    public String getDia_Chi() {
        return Dia_Chi;
    }

    public void setDia_Chi(String Dia_Chi) {
        this.Dia_Chi = Dia_Chi;
    }

    public String getTrang_Thai() {
        return Trang_Thai;
    }

    public void setTrang_Thai(String Trang_Thai) {
        this.Trang_Thai = Trang_Thai;
    }

    public String getNgay_Tao() {
        return Ngay_Tao;
    }

    public void setNgay_Tao(String Ngay_Tao) {
        this.Ngay_Tao = Ngay_Tao;
    }

    public Model_Khach_Hang(String ho_Ten, String ma_Khach_Hang, String so_Dien_Thoai, String trang_Thai) {
        this.Ho_Ten = ho_Ten;
        this.Ma_Khach_Hang = ma_Khach_Hang;
        this.So_Dien_Thoai = so_Dien_Thoai;
        this.Trang_Thai = trang_Thai;
    }

    public Model_Khach_Hang(String Ma_Khach_Hang, String Ho_Ten, String So_Dien_Thoai, String Email, String Gioi_Tinh, String Ngay_Sinh, String Dia_Chi, String Trang_Thai, String Ngay_Tao) {
        this.Ma_Khach_Hang = Ma_Khach_Hang;
        this.Ho_Ten = Ho_Ten;
        this.So_Dien_Thoai = So_Dien_Thoai;
        this.Email = Email;
        this.Gioi_Tinh = Gioi_Tinh;
        this.Ngay_Sinh = Ngay_Sinh;
        this.Dia_Chi = Dia_Chi;
        this.Trang_Thai = Trang_Thai;
        this.Ngay_Tao = Ngay_Tao;
    }

    public Model_Khach_Hang() {
    }

//    public Object[] toRowTable(EventActionNguoiMua event) {
//
//        return new Object[]{Ho_Ten, Ma_Khach_Hang, So_Dien_Thoai, Trang_Thai, new ModelAction(this, event)};
//    }
    public Object[] toRowTable(EventActionNguoiMua event) {
        if (event == null) {
            System.out.println("Lỗi: eventNguoiMua bị null khi truyền vào ModelAction!");
        } else {
            System.out.println("eventNguoiMua đã được truyền thành công.");
        }
        return new Object[]{Ho_Ten, Ma_Khach_Hang, So_Dien_Thoai, Trang_Thai, new ModelAction(this, event)};
    }
}
