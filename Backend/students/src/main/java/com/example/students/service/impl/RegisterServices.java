package com.example.students.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.students.model.Register;
import com.example.students.repository.IRegisterRepository;
import com.example.students.service.IRegisterServices;

@Service
public class RegisterServices implements IRegisterServices{

    @Autowired
    IRegisterRepository registerRepository;

    @Override
    public Register insertRegister(Register register) {
        // TODO Auto-generated method stub
        return registerRepository.insertRegister(register);
    }
    
}
