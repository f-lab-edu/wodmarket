package com.flab.wodmarket.domain.item;

import com.flab.wodmarket.domain.item.dto.ItemDto;
import com.flab.wodmarket.domain.item.dto.PageInfoDTO;
import com.flab.wodmarket.domain.item.dto.response.ItemResponseDTO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class ItemService {

    private final ItemMapper itemMapper;

    public ItemResponseDTO findAll(Pageable page) {
        Page<Item> items = itemMapper.findAll(page);
        PageInfoDTO pageInfo = new PageInfoDTO(
                items.getSize(),
                items.getTotalPages(),
                items.getTotalElements(),
                items.getNumber());

        return new ItemResponseDTO(items.getContent(), pageInfo);
    }


    public ItemDto findById(Long itemNo) {
        return itemMapper.findById(itemNo);
    }

    public void addItem(@NonNull ItemDto itemDto) {
        itemMapper.addItem(itemDto);
    }
}
