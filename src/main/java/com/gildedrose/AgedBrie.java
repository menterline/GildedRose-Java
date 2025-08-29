package com.gildedrose;
public class AgedBrie implements IItem {

    String name;
    int sellIn;
    int quality;

    public AgedBrie(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public int GetUpdatedQuality() {
        if (sellIn <= 0) {
            quality = Math.min(50, quality + 2);
        }
        if (sellIn > 0) {
            quality = Math.min(50, quality + 1);
        }
        return quality;
    }

    public int GetUpdatedSellin() {
        sellIn = sellIn - 1;
        return sellIn;
    }
    
    
}
