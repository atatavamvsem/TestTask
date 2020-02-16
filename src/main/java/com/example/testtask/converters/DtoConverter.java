package com.example.testtask.converters;

import com.example.testtask.models.User;
import com.example.testtask.models.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component("dtoConverter")
public class DtoConverter {

    @Autowired
    private ModelMapper modelMapper;

    public User convertToEntityUser(UserDto userDto)  {
        return modelMapper.map(userDto, User.class);
    }
}
