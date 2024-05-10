package com.flab.wodmarket.domain.category;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
@Slf4j
public class CategoryService {
    private final CategoryMapper categoryMapper;

    public List<Category> allCategory() {
        return categoryMapper.allList();
    }

    public Category findById(int no) {
        return categoryMapper.findById(no);
    }


    public void addCategory(int no, String name) {
        Optional<Category> existCategory = Optional.ofNullable(findById(no));
        if (existCategory.isPresent()) {
            log.info("log={}", existCategory);
            throw new IllegalArgumentException("이미 존재하는 카테고리입니다.");
        }
        categoryMapper.addCategory(no, name);
    }

    public void delete(int no) {
        Optional<Category> existCategory = Optional.ofNullable(findById(no));
        if (existCategory.isPresent()) {
            categoryMapper.deleteCategory(no);
        } else {
            throw new IllegalArgumentException("존재하지 않는 카테고리입니다.");
        }
    }
}
