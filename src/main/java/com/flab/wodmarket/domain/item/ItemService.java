package com.flab.wodmarket.domain.item;

import com.flab.wodmarket.domain.item.dto.ItemDto;
import java.util.List;
import java.util.Map;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class ItemService {

    private final ItemMapper itemMapper;

    public Page<Map<String, Object>> findAll(Map<String, Object> paramMap, Pageable page) {
        paramMap.put("offset", page.getOffset());
        paramMap.put("size", page.getPageSize());
        List<Map<String, Object>> itemList = itemMapper.findAll(paramMap);
        int count = itemMapper.countItem();
        return new PageImpl<>(itemList, page, count);
    }


    public ItemDto findById(Long itemNo) {
        return itemMapper.findById(itemNo);
    }

    public void addItem(@NonNull ItemDto itemDto) {
        itemMapper.addItem(itemDto);
    }
}
