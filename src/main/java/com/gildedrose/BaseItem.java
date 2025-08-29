package com.gildedrose;
public class BaseItem implements IItem {

    String name;
    int sellIn;
    int quality;

    public BaseItem(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public int GetUpdatedQuality() {
        return 0;
    }

    public int GetUpdatedSellin() {
        return 0;
    }
    
    
}
