package com.example.coindesk.dao;

import com.example.coindesk.Coindesk;
import com.example.coindesk.CoindeskRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CoindeskDaoImpl implements CoindeskDao{

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public String insert(Coindesk coindesk) {
        String sql = "INSERT INTO coindesk(code, symbol, rate, description, rateFloat, createdate, updatedate) VALUE (:code, :symbol, :rate, :description, :rateFloat, :createdate, :updatedate)";

        Map<String, Object> map = new HashMap<>();
        map.put("code", coindesk.getCode());
        map.put("symbol", coindesk.getSymbol());
        map.put("rate", coindesk.getRate());
        map.put("description", coindesk.getDescription());
        map.put("rateFloat", coindesk.getRateFloat());
        map.put("createdate", coindesk.getCreatedate());
        map.put("updatedate", coindesk.getUpdatedate());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);
        int id = keyHolder.getKey().intValue();
        System.out.println("mysql 自動生成的id為:" + id);
        return "執行 INSERT sql";

    }

    @Override
    public Coindesk getById(Integer coindeskId) {
        String sql = "SELECT id, code, symbol, rate, description, rateFloat, createdate, updatedate FROM coindesk WHERE id = :coindeskId";

        Map<String, Object> map = new HashMap<>();
        map.put("coindeskId", coindeskId);

        List<Coindesk> list = namedParameterJdbcTemplate.query(sql, map, new CoindeskRowMapper());

        if(list.size() > 0){
            return list.get(0);
        }else{
            return null;
        }
    }

    @Override
    public String delete(Integer coindeskId) {
        String sql = "DELETE FROM coindesk WHERE id = :coindeskId";

        Map<String, Object> map = new HashMap<>();

        map.put("coindeskId", coindeskId);

        namedParameterJdbcTemplate.update(sql, map);

        return "執行 DELETE sql";
    }

    @Override
    public String update(Coindesk coindesk, Integer coindeskId) {

        String sql = "UPDATE coindesk SET code=:code, symbol=:symbol, rate=:rate, description=:description, rateFloat=:rateFloat, createdate=:createdate, updatedate=:updatedate WHERE id=:coindeskId";

        Map<String, Object> map = new HashMap<>();

        map.put("code", coindesk.getCode());
        map.put("symbol", coindesk.getSymbol());
        map.put("rate", coindesk.getRate());
        map.put("description", coindesk.getDescription());
        map.put("rateFloat", coindesk.getRateFloat());
        map.put("createdate", coindesk.getCreatedate());
        map.put("updatedate", coindesk.getUpdatedate());
        map.put("coindeskId", coindeskId);

        namedParameterJdbcTemplate.update(sql, map);
        return "執行 UPDATE sql";
    }

}
