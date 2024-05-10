package com.flab.wodmarket.domain.item;

import com.flab.wodmarket.domain.item.dto.ItemDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Mapper
public interface ItemMapper {
    Page<Item> findAll(Pageable paramMap);

    int countItem();

    ItemDto findById(Long itemNo);

    void addItem(ItemDto itemDto);

}
