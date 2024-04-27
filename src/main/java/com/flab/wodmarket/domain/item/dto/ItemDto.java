package com.flab.wodmarket.domain.item.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.flab.wodmarket.domain.item.Item;
import com.flab.wodmarket.domain.item.ItemStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ItemDto {
    private Long itemNo;
    private String name;
    private Long price;
    private Long sale;
    private int stock;
    private int saleRate;
    private ItemStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime saleStartDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime saleEndDate;
    private String detail;

    @Builder
    public ItemDto(Long itemNo, String name, Long price, Long sale, int stock, int saleRate, ItemStatus status, LocalDateTime saleStartDate, LocalDateTime saleEndDate, String detail) {
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

    public static ItemDto of(Item item) {
        return ItemDto.builder()
                .itemNo(item.getItemNo())
                .name(item.getName())
                .price(item.getPrice())
                .sale(item.getSale())
                .stock(item.getStock())
                .saleRate(item.getSaleRate())
                .status(item.getStatus())
                .saleStartDate(item.getSaleStartDate())
                .saleEndDate(item.getSaleEndDate())
                .detail(item.getDetail())
                .build();
        }
}

