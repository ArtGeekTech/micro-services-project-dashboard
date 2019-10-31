package com.techbow.datadashboard.model.dao;

import com.techbow.datadashboard.model.dvo.Data;

import java.util.List;

public interface DataDao {
    Data save(Data data);
    Data findById(Long id);
    List<Data> findAll(String limit);
    List<Data> findByClientId(Long clientId, String field, String sort, String start, String end);
    Data update(Long id, Data data);
}
