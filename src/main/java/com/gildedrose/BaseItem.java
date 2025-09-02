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

        quality = Math.max(0, quality - 1);
        if (sellIn <= 1) {
            quality = Math.max(0, quality - 1);
        }
        return quality;
    }

    public int GetUpdatedSellin() {
        sellIn = sellIn - 1;
        return sellIn;
    }
    
    
}
