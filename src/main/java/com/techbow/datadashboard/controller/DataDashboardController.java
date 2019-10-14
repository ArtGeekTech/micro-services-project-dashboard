package com.techbow.datadashboard.controller;

import com.techbow.datadashboard.model.dao.DataDao;
import com.techbow.datadashboard.model.dvo.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
//@RestController
public class DataDashboardController {

    @Autowired
    private DataDao dataDao;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello() {
        // process...
        return "Hello";
    }

    @GetMapping("/hello2/{name}")
    @ResponseBody
    public String hello2(@PathVariable String name) {
        // process...
        return "Hello " + name;
    }

    @PostMapping("/data")
    @ResponseBody
    public Data createData(@RequestBody Data data) {
        return dataDao.save(data);
    }

    @GetMapping("/data/{id}")
    @ResponseBody
    public Data findDataById(@PathVariable Long id) {
        return dataDao.findById(id);
    }
}
