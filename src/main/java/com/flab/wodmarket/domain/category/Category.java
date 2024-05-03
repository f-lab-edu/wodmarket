package com.flab.wodmarket.domain.category;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Category {

    private Long no;
    private String name;

    @Builder
    public Category(String name, int no) {
        this.no = this.no;
        this.name = name;
    }


    public void addCategory(String name) {
        this.name = name;
    }
}
