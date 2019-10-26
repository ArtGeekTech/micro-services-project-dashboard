package com.techbow.datadashboard.controller;

import com.techbow.datadashboard.model.dao.DataDao;
import com.techbow.datadashboard.model.dvo.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController   // @Controller + @ResponseBody
@RequestMapping("api/v1")
public class DataDashboardController {

    @Autowired
    @Qualifier("jpa")
    private DataDao dataDao;

    @PostMapping("/data")
    public Data createData(@RequestBody Data data) {
        return dataDao.save(data);
    }


    @GetMapping("/data/{id}")
    @Cacheable(value = "dataCache", key = "#id")
    public Data getDataById(@PathVariable Long id) {
        System.out.println("\nCalling getDataById from DAO for data: " + id + "\n");
        return dataDao.findById(id);
    }

    @GetMapping("/data")
    public List<Data> getAllData(@RequestParam(name = "limit", required = false) String limit) {
        if (limit == null || limit.isEmpty()) {
            return dataDao.findAll();
        } else {
            return dataDao.findAllByLimit(Integer.valueOf(limit));
        }
    }


    @GetMapping("/data/client/{clientId}")
    public List<Data> findDataByClientId(
            @PathVariable Long clientId,
            @RequestParam(name = "order_by", required = false) String field,
            @RequestParam(name = "sort", required = false) String sort,
            @RequestParam(name = "start", required = false) String start,
            @RequestParam(name = "end", required = false) String end
    ) {
        if (field != null && field.equals("step_count") && sort != null && sort.equals("desc")) {
            if (start != null && !start.isEmpty() && end != null && !end.isEmpty()) {
                return dataDao.findByClientIdAndStepCountIsBetweenOrderByStepCountDesc(
                        clientId, Integer.valueOf(start), Integer.valueOf(end)
                );
            } else {
                return dataDao.findByClientIdOrderByStepCountDesc(clientId);
            }
        } else {
            return dataDao.findByClientId(clientId);
        }
    }


    @PutMapping("/data/{id}")
    @CachePut(value = "dataCache", key = "#id")
    public Data updateDataById(@PathVariable Long id, @RequestBody Data data) {
        Data res = dataDao.findById(id);
        if (res == null) {
//            throw new RuntimeException("id not exist");
            return null;
        } else {
            res.setClientId(data.getClientId());
            res.setStepCount(data.getStepCount());
            res.setTemperature(data.getTemperature());
            dataDao.save(res);
            return res;
        }
    }
}
