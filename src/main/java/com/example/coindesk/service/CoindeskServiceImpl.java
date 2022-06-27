package com.example.coindesk.service;

import com.example.coindesk.Coindesk;
import com.example.coindesk.dao.CoindeskDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CoindeskServiceImpl implements CoindeskService{

    @Autowired
   private CoindeskDao coindeskDao;

    @Override
    public String insert(Coindesk coindesk) {
        return coindeskDao.insert(coindesk);
    }

    @Override
    public Coindesk getById(Integer coindeskId) {return coindeskDao.getById(coindeskId);}

    @Override
    public String delete(Integer coindeskId) {return coindeskDao.delete(coindeskId);}

    @Override
    public String update(Coindesk coindesk, Integer coindeskId) {return coindeskDao.update(coindesk, coindeskId);}
}
