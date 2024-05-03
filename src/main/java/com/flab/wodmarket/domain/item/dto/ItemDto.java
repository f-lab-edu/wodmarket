package com.flab.wodmarket.domain.item.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.flab.wodmarket.domain.item.Item;
import com.flab.wodmarket.domain.item.ItemStatus;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemDto {
    private Long itemNo;
    private String name;
    private Long price;
    private Long sale;
    private int stock;
    private int saleRate;
    private ItemStatus itemStatus;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime saleStartDateTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime saleEndDateTime;
    private String itemInfo;

    @Builder
    public ItemDto(Long itemNo, String name, Long price, Long sale, int stock, int saleRate, ItemStatus itemStatus,
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

    public static ItemDto of(Item item) {
        return ItemDto.builder()
                .itemNo(item.getItemNo())
                .name(item.getName())
                .price(item.getPrice())
                .sale(item.getSale())
                .stock(item.getStock())
                .saleRate(item.getSaleRate())
                .itemStatus(item.getItemStatus()).build();
    }
}

