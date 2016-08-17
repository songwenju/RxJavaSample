package com.example.songwenju.rxjavasample.example;

import java.util.List;

/**
 * songwenju on 16-8-17 : 10 : 43.
 * 邮箱：songwenju@outlook.com
 */
public class ItemListEvent {
    private List<Item> mItems;

    public ItemListEvent(List<Item> items) {
        mItems = items;
    }

    public List<Item> getItems() {
        return mItems;
    }
}
