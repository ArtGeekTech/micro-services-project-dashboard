package com.techbow.datadashboard.model.dao.impl;

import com.techbow.datadashboard.model.dao.DataDao;
import com.techbow.datadashboard.model.dvo.Data;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//@Component
//public class DataHashMapDao implements DataDao {
//
//    private Map<Long, Data> map = new HashMap<>();
//
//    @Override
//    // persist new & existing record.
//    public Data save(Data data) {
//        Long id = data.getId();
//        // Only if is a new record.
//        if (id == null || !map.containsKey(id)) {
//            id = map.size() + 1L;
//            data.setId(id);
//            data.setCreatedAt(new Date());
//        }
//        data.setUpdatedAt(new Date());
//        map.put(id, data);
//        return data;
//    }
//
//    @Override
//    public Data findById(Long id) {
//        return map.get(id);
//    }
//}
