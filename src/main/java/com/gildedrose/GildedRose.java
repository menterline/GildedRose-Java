package com.gildedrose;

import java.util.function.Function;
import java.util.function.Supplier;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void legacyUpdateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }

    public void updateQuality() {
        for (Item item : items) {
            Supplier<UpdateResult> updater = parseItem(item);
            UpdateResult result = updater.get();
            int newQuality = result.quality;
            int newSellin = result.sellIn;
            int multiplier = 1; // Conjured items degrade twice as fast
            if (item.name.startsWith("Conjured")) {
                multiplier = 2;
            }
            item.quality = item.quality - (item.quality - newQuality) * multiplier;
            item.sellIn = newSellin;
        }
    }

    private Supplier<UpdateResult> parseItem(Item item) {
        switch (item.name) {
            case "Aged Brie":
                return () -> Updater.AgedBrie(item.quality, item.sellIn);
            case "Backstage passes to a TAFKAL80ETC concert":
                return () -> Updater.BackstagePass(item.quality, item.sellIn);
            case "Sulfuras, Hand of Ragnaros":
                return () -> Updater.Sulfuras(item.quality, item.sellIn);
            default:
                return () -> Updater.NormalItem(item.quality, item.sellIn);
        }
    }
}
