package com.example.nameservice;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface NameMapper {

    @Select("SELECT * FROM names WHERE name LIKE CONCAT(#{prefix}, '%')")
    List<Name> findByNameStartingWith(String prefix);

    @Select("SELECT * FROM names WHERE id = #{id}")
    Optional<Name> findById(int id);
}
