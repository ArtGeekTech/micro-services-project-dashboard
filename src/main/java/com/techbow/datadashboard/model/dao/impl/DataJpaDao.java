package com.techbow.datadashboard.model.dao.impl;

import com.techbow.datadashboard.model.dao.DataDao;
import com.techbow.datadashboard.model.dao.repository.DataJpaRepository;
import com.techbow.datadashboard.model.dvo.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Qualifier("jpa")
public class DataJpaDao implements DataDao {

    @Autowired
    private DataJpaRepository repository;

    @Override
    public Data save(Data data) {
        Data res = repository.save(data);
        return res;
    }

    @Override
    public Data findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Data> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Data> findByClientId(Long clientId) {
        return repository.findByClientId(clientId);
    }

    @Override
    public List<Data> findAllByLimit(Integer limit) {
        return repository.findAllByLimit(Integer.valueOf(limit));
    }

    @Override
    public List<Data> findByClientIdOrderByStepCountDesc(Long clientId) {
        return repository.findByClientIdOrderByStepCountDesc(clientId);
    }

    @Override
    public List<Data> findByClientIdAndStepCountIsBetweenOrderByStepCountDesc(Long clientId, Integer start, Integer end) {
        return repository.findByClientIdAndStepCountIsBetweenOrderByStepCountDesc(clientId, start, end);
    }
}
