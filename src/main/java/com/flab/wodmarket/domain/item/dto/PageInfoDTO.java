package com.flab.wodmarket.domain.item.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageInfoDTO {
    private int size;
    private int totalPages;
    private long totalElements;
    private int number;

    public PageInfoDTO(int size, int totalPages, long totalElements, int number) {
        this.size = size;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.number = number;
    }
}
