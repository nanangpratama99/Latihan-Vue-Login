package com.example.students.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.students.model.Register;
import com.example.students.repository.IRegisterRepository;

@Repository
public class RegisterRepository implements IRegisterRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Register insertRegister(Register register) {
        String query = "INSERT INTO tb_register(email, gender, nama, password, phone_number, username) "
                + "VALUES(?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(query,
                new Object[] { register.getEmail(), register.getGender(), register.getNama(), register.getPassword(),
                        register.getPhone_number(), register.getUsername(), });
        return register;
    }

}
