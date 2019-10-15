package com.techbow.datadashboard.model.dao;

import com.techbow.datadashboard.model.dvo.Data;

import java.util.List;

public interface DataDao {
    Data save(Data data);
    Data findById(Long id);
    List<Data> findAll();
    List<Data> findByClientId(Long clientId);
    List<Data> findAllByLimit(Integer limit);
}
