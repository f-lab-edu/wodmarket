package com.flab.wodmarket.domain.item;

import com.flab.wodmarket.domain.item.dto.ItemDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
@Slf4j
public class ItemService {

    private final ItemMapper itemMapper;

    public List<Item> allItem() {
        return itemMapper.allItem();
    }

    public ItemDto getListOne(Long itemNo) {
        return itemMapper.getListOne(itemNo);
    }

 /*   public void addItem(@NonNull ItemDto itemDto) {
        itemMapper.addItem(itemDto);
    }*/
}
