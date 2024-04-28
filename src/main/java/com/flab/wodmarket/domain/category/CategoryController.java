package com.flab.wodmarket.domain.category;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("category")
@RestController
@RequiredArgsConstructor
@Slf4j
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<String>> allCategory(){
        List<String> categoryList = categoryService.allCategory();
        return ResponseEntity.ok().body(categoryList);
    }

    @PutMapping("/{categoryNo}")
    public ResponseEntity<Integer> addCategory(@PathVariable("categoryNo") int categoryNo, @RequestBody String categoryName){
        categoryService.addCategory(categoryName, categoryNo);
        return ResponseEntity.ok().body(categoryNo);
    }






}
