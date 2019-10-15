package com.techbow.datadashboard.model.dao.impl;

import com.techbow.datadashboard.model.dao.DataDao;
import com.techbow.datadashboard.model.dvo.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("jpa")
public class DataJpaDao implements DataDao {

    @Override
    public Data save(Data data) {
        return null;
    }

    @Override
    public Data findById(Long id) {
        return null;
    }
}
