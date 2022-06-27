package com.example.coindesk.controller;

import com.example.coindesk.Coindesk;
import com.example.coindesk.service.CoindeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CoindeskController {

    @Autowired
    private CoindeskService coindeskService;

    @PostMapping("/coindesks")
    public String insert (@RequestBody Coindesk coindesk){
        return coindeskService.insert(coindesk);
    }

    @PutMapping("/coindesks/{coindeskId}")
    public String update(@RequestBody Coindesk coindesk ,@PathVariable Integer coindeskId){
        return coindeskService.update(coindesk, coindeskId);
    }

    @GetMapping("/coindesks/{coindeskId}")
    public Coindesk select(@PathVariable Integer coindeskId){
        return coindeskService.getById(coindeskId);
    }

    @DeleteMapping("/coindesks/{coindeskId}")
    public String delete(@PathVariable Integer coindeskId){
        return coindeskService.delete(coindeskId);
    }

}
