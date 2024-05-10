package com.flab.wodmarket.domain.item.dto.response;

import com.flab.wodmarket.domain.item.Item;
import com.flab.wodmarket.domain.item.dto.PageInfoDTO;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemResponseDTO {
    private List<Item> items;
    private PageInfoDTO pageInfo;

    public ItemResponseDTO(List<Item> items, PageInfoDTO pageInfo) {
        this.items = items;
        this.pageInfo = pageInfo;
    }
}
