package com.flab.wodmarket.domain.category;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Category {

        private Long categoryNo;
        private String categoryName;
        @Builder
        public Category(Long categoryNo, String categoryName) {
            this.categoryNo = categoryNo;
            this.categoryName = categoryName;
        }


}
