package kr.legossol.api.item.service;

import java.util.Optional;

import kr.legossol.api.item.domain.Item;

public interface ItemService {
    // public Optional<Item> updateItem(Long itemno,Item item);
    // public Item updateWith(Item newItem);
    public void updateItem(Long itemId,Item item);
}
