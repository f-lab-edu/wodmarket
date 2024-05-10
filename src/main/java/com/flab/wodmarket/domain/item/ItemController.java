package com.flab.wodmarket.domain.item;

import com.flab.wodmarket.domain.item.dto.ItemDto;
import com.flab.wodmarket.domain.item.dto.response.ItemResponseDTO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("item")
@RestController
@RequiredArgsConstructor
@Slf4j
public class ItemController {

    private final ItemService itemService;

    @ResponseBody
    @GetMapping("/all")
    public ResponseEntity<Object> findAll(@PageableDefault(value = 10) Pageable page) {
        ItemResponseDTO response = itemService.findAll(page);
        return ResponseEntity.ok().body(response);
    }


    @GetMapping("/{itemNo}")
    public ItemDto findById(@PathVariable Long itemNo) {
        return itemService.findById(itemNo);
    }

    @PostMapping("/{newItem}")
    public ResponseEntity<ItemDto> addItem(@RequestBody @NonNull ItemDto itemDto) {
        itemService.addItem(itemDto);
        return ResponseEntity.ok().body(itemDto);
    }

}