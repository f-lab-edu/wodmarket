package com.flab.wodmarket.domain.item;

import com.flab.wodmarket.domain.item.dto.ItemDto;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemMapper {
    List<Map<String, Object>> findAll(Map<String, Object> paramMap);

    int countItem();

    ItemDto findById(Long itemNo);

    void addItem(ItemDto itemDto);

}
