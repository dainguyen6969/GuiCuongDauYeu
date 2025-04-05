package com.dai.model;

import com.dai.swing.table.EventAction.EventActionQuanTriVien;
import com.dai.swing.table.ModelAction;

/**
 *
 * @author dainguyen
 */
public class Model_Quan_Tri_Vien {

    private String idAdmin;
    private String tenAdmin;
    private String trangThai;
    private String ngayTao;

    public String getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(String idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getTenAdmin() {
        return tenAdmin;
    }

    public void setTenAdmin(String tenAdmin) {
        this.tenAdmin = tenAdmin;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Model_Quan_Tri_Vien() {
    }

    public Model_Quan_Tri_Vien(String idAdmin, String tenAdmin, String trangThai, String ngayTao) {
        this.idAdmin = idAdmin;
        this.tenAdmin = tenAdmin;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
    }

    public Object[] toRowTable(EventActionQuanTriVien event) {
        return new Object[]{idAdmin, tenAdmin, trangThai, ngayTao ,new ModelAction(this, event)};
    }
}
