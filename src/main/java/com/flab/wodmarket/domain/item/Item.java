package com.flab.wodmarket.domain.item;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Item {
    private Long itemNo;
    private String name;
    private Long price;
    private Long sale;
    private int stock;
    private int saleRate;
    private ItemStatus itemStatus;
    private LocalDateTime saleStartDateTime;
    private LocalDateTime saleEndDateTime;
    private String itemInfo;

    @Builder
    public Item(Long itemNo, String name, Long price, Long sale, int stock, int saleRate, ItemStatus itemStatus,
                LocalDateTime saleStartDateTime, LocalDateTime saleEndDateTime, String itemInfo) {
        this.itemNo = itemNo;
        this.name = name;
        this.price = price;
        this.sale = sale;
        this.stock = stock;
        this.saleRate = saleRate;
        this.itemStatus = itemStatus;
        this.saleStartDateTime = saleStartDateTime;
        this.saleEndDateTime = saleEndDateTime;
        this.itemInfo = itemInfo;
    }
}


