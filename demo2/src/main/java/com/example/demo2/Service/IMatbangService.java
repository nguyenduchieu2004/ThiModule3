package com.example.demo2.Service;

import com.example.demo2.Model.MatBang;

import java.util.List;

public interface IMatbangService {
    List<MatBang> getAll();
    void save(MatBang matBang);
    void add(MatBang matBang);
    void delete(int id);

}
