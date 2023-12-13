package com.telusko.SpringBootJDBCTemplate.repo;

import com.telusko.SpringBootJDBCTemplate.models.Aliens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AliensRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Aliens alien)
    {
        String sql = "insert into aliens(id,name,tech) values(?,?,?)";
        int rows = jdbcTemplate.update(sql,alien.getId(),alien.getName(),alien.getTech());
        System.out.println("No of rows affected : "+rows);
    }
    public List<Aliens> findAll()
    {
        String sql = "select * from ALIENS";
        RowMapper<Aliens> mapper = new RowMapper<Aliens>() {
            @Override
            public Aliens mapRow(ResultSet rs, int rowNum) throws SQLException {
                Aliens a = new Aliens();
                a.setId(rs.getInt(1));
                a.setName(rs.getString(2));
                a.setTech(rs.getString(3));
                return a;
            }

        };
        List<Aliens> aliens = this.jdbcTemplate.query(sql,mapper);
        return  aliens;
    }
}
