package com.mt.controller;

import com.mt.config.datasource.DataSource;
import com.mt.config.datasource.DataSourceType;
import com.mt.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TestController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/selectAll")
    @DataSource(DataSourceType.SLAVE)
    public void selectAll(){
       userMapper.selectAll();
    }

    @GetMapping("/selectById/{id}")
    @DataSource(DataSourceType.SLAVE)
    public void selectById(@PathVariable Integer id){
        userMapper.selectById(id);
    }

    @GetMapping("/delete/{id}")
    @DataSource(DataSourceType.MASTER)
    public void deleteById(@PathVariable Integer id){
        userMapper.delete(id);
    }

}
