package com.flab.wodmarket.domain.category;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CategoryMapper {
    List<Category> allList();

    Category findById(int no);

    void addCategory(int no, @Param("categoryName") String name);

    void deleteCategory(int no);
}
