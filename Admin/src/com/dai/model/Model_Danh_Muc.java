package com.dai.model;

import com.dai.swing.table.EventAction.EventAction;
import com.dai.swing.table.EventAction.EventActionDanhMuc;
import com.dai.swing.table.EventAction.EventActionNguoiBan;
import com.dai.swing.table.ModelAction;
import com.dai.swing.table.ModelProfile;
import java.text.DecimalFormat;
import javax.swing.Icon;

public class Model_Danh_Muc {

    public int getSoLuongSanPham() {
        return SoLuongSanPham;
    }

    public void setSoLuongSanPham(int SoLuongSanPham) {
        this.SoLuongSanPham = SoLuongSanPham;
    }

    private String ID_Danh_Muc;
    private String LoaiHang;
    private String Ten_Danh_Muc;
    private Icon AnhDanhMuc;
    private String TrangThai;
    private int SoLuongSanPham;
    public String getID_Danh_Muc() {
        return ID_Danh_Muc;
    }

    public void setID_Danh_Muc(String ID_Danh_Muc) {
        this.ID_Danh_Muc = ID_Danh_Muc;
    }

    public String getLoaiHang() {
        return LoaiHang;
    }

    public void setLoaiHang(String LoaiHang) {
        this.LoaiHang = LoaiHang;
    }

    public String getTen_Danh_Muc() {
        return Ten_Danh_Muc;
    }

    public void setTen_Danh_Muc(String Ten_Danh_Muc) {
        this.Ten_Danh_Muc = Ten_Danh_Muc;
    }

    public Icon getAnhDanhMuc() {
        return AnhDanhMuc;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public Model_Danh_Muc() {
    }

    public void setAnhDanhMuc(Icon AnhDanhMuc) {
        this.AnhDanhMuc = AnhDanhMuc;
    }

    public Model_Danh_Muc(String ID_Danh_Muc, String LoaiHang, String Ten_Danh_Muc, Icon AnhDanhMuc, String TrangThai, int SoLuongSanPham) {
        this.ID_Danh_Muc = ID_Danh_Muc;
        this.LoaiHang = LoaiHang;
        this.Ten_Danh_Muc = Ten_Danh_Muc;
        this.AnhDanhMuc = AnhDanhMuc;
        this.TrangThai = TrangThai;
        this.SoLuongSanPham = SoLuongSanPham;
    }

    

    public Model_Danh_Muc(Icon AnhDanhMuc , String Ten_Danh_Muc, String ID_Danh_Muc, int SoLuongSanPham, String TrangThai) {
        this.ID_Danh_Muc = ID_Danh_Muc;
        this.Ten_Danh_Muc = Ten_Danh_Muc;
        this.AnhDanhMuc = AnhDanhMuc;
        this.SoLuongSanPham = SoLuongSanPham;
        this.TrangThai = TrangThai;
    }

    public Object[] toRowTable(EventActionDanhMuc event) {
        return new Object[]{new ModelProfile(AnhDanhMuc, Ten_Danh_Muc), ID_Danh_Muc, SoLuongSanPham,TrangThai, new ModelAction(this, (event))};
    }
}
