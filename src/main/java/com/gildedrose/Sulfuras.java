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

    public int GetUpdatedQuality() {
        return quality;
    }

    public int GetUpdatedSellin() {
        return sellIn;
    }
    
    
}
