package com.techbow.datadashboard.model.dao.impl;

import com.techbow.datadashboard.model.dao.DataDao;
import com.techbow.datadashboard.model.dvo.Data;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DataHashMapDao implements DataDao {

    private Map<Long, Data> map = new HashMap<>();

    @Override
    // persist new & existing record
    public Data save(Data data) {
        Long id = data.getId();
        if (id == null || !map.containsKey(id)) {
            id = map.size() + 1L;
            data.setId(id);
        }
        map.put(id, data);
        return data;
    }

    @Override
    public Data findById(Long id) {
        return map.get(id);
    }
}
