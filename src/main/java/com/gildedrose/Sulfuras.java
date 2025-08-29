package com.gildedrose;
public class Sulfuras implements IItem {

    String name;
    int sellIn;
    int quality;

    public Sulfuras(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = 80;
    }
    public int getQuality() {
        return quality;
    }
    public int getSellIn() {
        return sellIn;
    }

    public void updateQuality() {
        return;
    }

    public void updateSellIn() {
        return;
    }
    
    
}
