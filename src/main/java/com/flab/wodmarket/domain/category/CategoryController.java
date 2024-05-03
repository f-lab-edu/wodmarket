package com.flab.wodmarket.domain.category;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("category")
@RestController
@RequiredArgsConstructor
@Slf4j
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> allCategory() {
        List<Category> categoryList = categoryService.allCategory();
        return ResponseEntity.ok().body(categoryList);
    }

    @PutMapping("/{categoryNo}")
    public ResponseEntity<Integer> addCategory(@PathVariable("categoryNo") int no,
                                               @RequestBody @Param("categoryName") String name) {
        categoryService.addCategory(no, name);
        return ResponseEntity.ok().body(no);
    }

    @DeleteMapping("/{categoryNo}")
    public ResponseEntity<Integer> delete(@PathVariable("categoryNo") int no) {
        categoryService.delete(no);
        return ResponseEntity.ok().body(no);
    }


}
