package com.flab.wodmarket.domain.category;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CategoryMapper {

    List<String> allCategory();

    Category findById(int categoryNo);

    void addCategory(String categoryName);

}
