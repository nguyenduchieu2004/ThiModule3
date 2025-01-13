package com.example.demo2.Service;

import com.example.demo2.Model.MatBang;
import com.example.demo2.Repository.MatbangRepository;

import java.util.List;

public class MatbangService implements IMatbangService{
    private MatbangRepository repository=new MatbangRepository();


    @Override
    public List<MatBang> getAll() {
        return repository.getAll();
    }

    @Override
    public void save(MatBang matBang) {

    }

    @Override
    public void add(MatBang matBang) {

    }

    @Override
    public void delete(int id) {
    repository.delete(id);
    }
}
