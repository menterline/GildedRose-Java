package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) { 
            IItem iItem = parseItem(item);
            iItem.updateQuality();
            iItem.updateSellIn();
            item.quality = iItem.getQuality();
            item.sellIn = iItem.getSellIn();
        }
    }

    private IItem parseItem(Item item) {
        switch (item.name) {
            case "Aged Brie":
                return new AgedBrie(item.name, item.sellIn, item.quality);
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePass(item.name, item.sellIn, item.quality);
            case "Sulfuras, Hand of Ragnaros":
                return new Sulfuras(item.name, item.sellIn, item.quality);
            default:
                return new BaseItem(item.name, item.sellIn, item.quality);
        }
    }
}
