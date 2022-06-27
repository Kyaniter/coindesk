package com.example.coindesk.dao;

import com.example.coindesk.Coindesk;

public interface CoindeskDao {

    String insert(Coindesk coindesk);

    Coindesk getById(Integer coindeskId);

    String delete(Integer coindeskId);

    String update(Coindesk coindesk, Integer coindeskId);

}
