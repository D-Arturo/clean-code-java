package com.a.introduction.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GildedRoseADefaultItemTest {

	public static final int NOT_EXPIRED_SELLIN = 15;
	public static final int DEFAULT_QUALITY = 3;
	public static final String DEFAULT_ITEM = "DEFAULT_ITEM";
	public static final int EXPIRED_SELLIN = -1;

	private GildedRose createGildedRoseWithOneItem(String ItemType, int sellin, int quality) {
		Item item = new Item(ItemType, sellin, quality);
		Item[] items = new Item[] { item };
		GildedRose app = new GildedRose(items);
		return app;
	}

	@Test
	public void unexpiredDefaultItem_qualityDecreasesByOneAndSellinByOne() {

		GildedRose app = createGildedRoseWithOneItem(DEFAULT_ITEM, NOT_EXPIRED_SELLIN, DEFAULT_QUALITY);
		app.updateQuality();
		assertEquals(DEFAULT_ITEM, app.items[0].name);
		assertEquals(NOT_EXPIRED_SELLIN - 1, app.items[0].sellIn);
		assertEquals(DEFAULT_QUALITY - 1, app.items[0].quality);
	}

	/**
	 * Method to test the variation in quality of the item for the non expired
	 * Item.
	 *
	 * The quality should decrease by 2 when the item is expired(Sell in  < 0) and sell in should decrease by 1.
	 *
	 */
	@Test
	public void expiredDefaultItem_qualityDecreasesByTwoAndSellinByOne() {
		GildedRose app = createGildedRoseWithOneItem(DEFAULT_ITEM, EXPIRED_SELLIN, DEFAULT_QUALITY);

		app.updateQuality();
		assertEquals(DEFAULT_ITEM, app.items[0].name);
		assertEquals(EXPIRED_SELLIN - 1, app.items[0].sellIn);
		assertEquals(DEFAULT_QUALITY - 2, app.items[0].quality);
	}
}