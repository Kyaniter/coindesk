package com.example.coindesk.service;

import com.example.coindesk.Coindesk;

public interface CoindeskService {

    String insert(Coindesk coindesk);

    Coindesk getById(Integer coindeskId);

    String delete(Integer coindeskId);

    String update(Coindesk coindesk, Integer coindeskId);
}
