package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }
    @Test
    void AgedBrie_NotExpired() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 12) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(13, app.items[0].quality);
    }

    @Test
    void AgedBrie_IsExpiring() {
        Item[] items = new Item[] { new Item("Aged Brie", 1, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(6, app.items[0].quality);
    }
    @Test
    void AgedBrie_Expired() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(7, app.items[0].quality);
    }
    @Test
    void AgedBrie_NeverOver50() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void BackstagePasses_LessThan11Days() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 9, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].sellIn);
        assertEquals(12, app.items[0].quality);
    }
    @Test
    void BackstagePasses_LessThan6Days() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(13, app.items[0].quality);
    }
    @Test
    void BackstagePasses_Expired() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }
    @Test
    void Sulfuras_NeverExpiresAndNeverDegrades() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }
    @Test
    void Combined() {
        Item agedBrie = new Item("Aged Brie", 0, 5);
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 10, 80);
        Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10);
        GildedRose app = new GildedRose(new Item[] { agedBrie, sulfuras, backstagePass });
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(7, app.items[0].quality);
        assertEquals(10, app.items[1].sellIn);
        assertEquals(80, app.items[1].quality);
        assertEquals(4, app.items[2].sellIn);
        assertEquals(13, app.items[2].quality);
    }
}
