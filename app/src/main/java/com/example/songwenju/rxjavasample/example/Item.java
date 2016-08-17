package com.example.songwenju.rxjavasample.example;

import java.util.ArrayList;
import java.util.List;

public class Item {
    public String id;
    public String content;

    public static List<Item> ITEMS = new ArrayList<Item>();

    static {
        // Add 6 sample items.
        addItem(new Item("1", "1.轮询请求"));
        addItem(new Item("2", "2.使用merge合并两个数据源"));
        addItem(new Item("3", "3.使用timer做定时操作"));
        addItem(new Item("4", "4.使用interval做周期性操作"));
        addItem(new Item("5", "5.使用throttleFirst防止按钮重复点击"));
        addItem(new Item("6", "6.使用schedulePeriodically做轮询请求"));
        addItem(new Item("7", "7.RxJava进行数组、list的遍历"));
        addItem(new Item("8", "8.响应式的界面"));
    }

    private static void addItem(Item item) {
        ITEMS.add(item);
    }

    public Item(String id, String content) {
        this.id = id;
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }
}