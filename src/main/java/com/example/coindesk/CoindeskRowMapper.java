package com.example.coindesk;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CoindeskRowMapper implements RowMapper<Coindesk> {

    @Override
    public Coindesk mapRow(ResultSet resultSet, int i) throws SQLException {
        Coindesk coindesk = new Coindesk();
        coindesk.setId(resultSet.getInt("id"));
        coindesk.setCode(resultSet.getString("code"));
        coindesk.setSymbol(resultSet.getString("symbol"));
        coindesk.setRate(resultSet.getString("rate"));
        coindesk.setDescription(resultSet.getString("description"));
        coindesk.setRateFloat(resultSet.getDouble("rateFloat"));
        coindesk.setCreatedate(resultSet.getDate("createdate"));
        coindesk.setUpdatedate(resultSet.getDate("updatedate"));
        return coindesk;
    }
}
