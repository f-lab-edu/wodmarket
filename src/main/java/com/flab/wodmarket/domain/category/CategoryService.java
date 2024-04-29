package com.flab.wodmarket.domain.category;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class CategoryService {
    private final CategoryMapper categoryMapper;

    public List<String> allCategory() {
        return categoryMapper.allCategory();
    }

    public Category findById(int categoryNo) {
        return categoryMapper.findById(categoryNo);
    }


    public void addCategory(String categoryName, int categoryNo) {
        Category existCategory = findById(categoryNo);
        if(existCategory == null)
            categoryMapper.addCategory(categoryName);
        else
            throw new IllegalArgumentException("이미 존재하는 카테고리입니다.");

    }
}
