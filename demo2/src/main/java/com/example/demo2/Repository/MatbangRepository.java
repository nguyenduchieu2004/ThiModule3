package com.example.demo2.Repository;

import com.example.demo2.Model.MatBang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MatbangRepository {
    private static List<MatBang> matBangs = new ArrayList<>();
    private static final String SELECT_ALL_MAT_BANG = "SELECT * FROM mat_bang ORDER BY dien_tich ASC";

    public List<MatBang> getAll() {
        List<MatBang> matBangList = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MAT_BANG)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String maMatBang = rs.getString("ma_mat_bang");
                String trangThai = rs.getString("trang_thai");
                float dienTich = rs.getFloat("dien_tich");
                int tang = rs.getInt("tang");
                String loaiMatBang = rs.getString("loai_mat_bang");
                long giaTien = rs.getLong("gia_tien");
                String ngayBatDau = rs.getString("ngay_bat_dau");
                String ngayKetThuc = rs.getString("ngay_ket_thuc");

                MatBang matBang = new MatBang(maMatBang, trangThai, dienTich, tang, loaiMatBang, giaTien, ngayBatDau, ngayKetThuc);
                matBangList.add(matBang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return matBangList;
    }

    public void delete(int id) {
    for(MatBang matBang:matBangs) {
        if(matBang.getId() == id) {
            matBangs.remove(matBang);
            }
        }
    }
}