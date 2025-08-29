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

    public int getQuality() {
        return quality;
    }
    public int getSellIn() {
        return sellIn;
    }

    public void updateQuality() {
        if (sellIn <= 0) {
            quality = Math.min(50, quality + 2);
        }
        if (sellIn > 0) {
            quality = Math.min(50, quality + 1);
        }
    }

    public void updateSellIn() {
        sellIn = sellIn - 1;
    }
    
    
}
