package com.gildedrose;
public class BackstagePass implements IItem {

    String name;

    int sellIn;

    int quality;

    public BackstagePass(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public int GetUpdatedQuality() {
        if (sellIn <= 0) {
            quality = 0;
        } else if (sellIn < 6) {
            quality = Math.min(50, quality + 3);
        } else if (sellIn < 11) {
            quality = Math.min(50, quality + 2);
        } else {
            quality = Math.min(50, quality + 1);
        }
        return quality;
    }

    public int GetUpdatedSellin() {
        sellIn = sellIn - 1;
        return sellIn;
    }
    
    
}
