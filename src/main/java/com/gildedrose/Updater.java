package com.gildedrose;

public class Updater {
    public static UpdateResult AgedBrie(int quality, int sellIn) {
        int newQuality = quality;
        if (sellIn <= 0) {
            newQuality = Math.min(50, quality + 2);
        }
        if (sellIn > 0) {
            newQuality = Math.min(50, quality + 1);
        }
        int newSellIn = sellIn - 1;
        return new UpdateResult(newSellIn, newQuality);
    }

    public static UpdateResult BackstagePass(int quality, int sellIn) {
        int newQuality = quality;
        if (sellIn <= 0) {
            newQuality = 0;
        } else if (sellIn < 6) {
            newQuality = Math.min(50, quality + 3);
        } else if (sellIn < 11) {
            newQuality = Math.min(50, quality + 2);
        } else {
            newQuality = Math.min(50, quality + 1);
        }
        int newSellIn = sellIn - 1;
        return new UpdateResult(newSellIn, newQuality);
    }

    public static UpdateResult Sulfuras(int quality, int sellIn) {
        return new UpdateResult(sellIn, quality);
    }
    public static UpdateResult NormalItem(int quality, int sellIn) {
        int newQuality = Math.max(0, quality - 1);
        if (sellIn <= 1) {
            newQuality = Math.max(0, newQuality - 1);
        }
        int newSellIn = sellIn - 1;
        return new UpdateResult(newSellIn, newQuality);
    }
}
