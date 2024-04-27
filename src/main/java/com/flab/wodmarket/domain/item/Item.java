package com.flab.wodmarket.domain.item;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class Item {
    private Long itemNo;
    private String name;
    private Long price;
    private Long sale;
    private int stock;
    private int saleRate;
    private ItemStatus status;
    private LocalDateTime saleStartDate;
    private LocalDateTime saleEndDate;
    private String detail;

    @Builder
    public Item(Long itemNo, String name, Long price, Long sale, int stock, int saleRate, ItemStatus status, LocalDateTime saleStartDate, LocalDateTime saleEndDate, String detail) {
        this.itemNo = itemNo;
        this.name = name;
        this.price = price;
        this.sale = sale;
        this.stock = stock;
        this.saleRate = saleRate;
        this.status = status;
        this.saleStartDate = saleStartDate;
        this.saleEndDate = saleEndDate;
        this.detail = detail;
    }
}


