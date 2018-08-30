package com.scarlatti.todo;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Wednesday, 8/29/2018
 */
public class TodoDao {

    private JdbcTemplate jdbcTemplate;

    public TodoDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Todo> getTodos() {
        return jdbcTemplate.query("select * from TODO", (rs, rowNum) -> {
            Todo todo = new Todo();
            todo.setText(rs.getString("TEXT"));
            todo.setCompleted(rs.getString("COMPLETED_IND").equals("Y"));
            return todo;
        });
    }
}
