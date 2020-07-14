package com.mt.mapper;

import com.mt.bean.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user")
    public List<User> selectAll();

    @Select("select * from user where id = #{id}")
    public List<User> selectById(Integer id);

    @Delete("delete from user where id = #{id}")
    public void delete(Integer id);

}
