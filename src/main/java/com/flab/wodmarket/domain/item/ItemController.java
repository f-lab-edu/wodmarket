package com.flab.wodmarket.domain.item;

import com.flab.wodmarket.domain.item.dto.ItemDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("item")
@RestController
@RequiredArgsConstructor
@Slf4j
public class ItemController {

    private final ItemService itemService;

    public ResponseEntity<List<Item>> allItem(){
        List<Item> itemList = itemService.allItem();
        return ResponseEntity.ok().body(itemList);
    }

    @GetMapping("{itemNo}")
    public ItemDto getListOne(@PathVariable Long itemNo){
        return itemService.getListOne(itemNo);
    }

  /*  @PostMapping("/{newItem}")
    public ResponseEntity<ItemDto> addItem(@RequestBody @NonNull ItemDto itemDto){
        itemService.addItem(itemDto);
        return ResponseEntity.ok().body(itemDto);
    }*/

}