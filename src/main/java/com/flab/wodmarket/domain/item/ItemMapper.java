package com.flab.wodmarket.domain.item;

import com.flab.wodmarket.domain.item.dto.ItemDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {
    List<Item> allItem();
    ItemDto getListOne(Long itemNo);

    // void addItem(ItemDto itemDto);

}
