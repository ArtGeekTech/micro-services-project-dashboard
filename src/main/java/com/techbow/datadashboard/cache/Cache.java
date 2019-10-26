package com.techbow.datadashboard.cache;

import com.techbow.datadashboard.model.dvo.Data;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Cache {
    private Map<String, Data> map = new HashMap<>();

    public Data get(String key) {
        if (map.containsKey(key)) {
            Data res = map.get(key);
            System.out.println("Getting from Cache for Data Id: " + res.getId());
            return res;
        } else {
            return null;
        }
    }

    public void put(String key, Data data) {
        System.out.println("Putting from Cache for Data Key: " + key + "; Data id: " + data.getId());
        map.put(key, data);
    }
}
