package schiffer.flicker;

import java.io.IOException;
import java.util.Arrays;

/*
 * The class that represents the json feed from Flicker
 */
public class FlickerFeed {
	// this is what we'll get out of gson.
	private Item[] items;

	public FlickerFeed() throws IOException {
		this.items = new Item[20];
	}

	public Item[] getItems() {
		return items;
	}

	public Item getItem(int i) {
		return items[i];
	}

	@Override
	public String toString() {
		return "ArrayItems [items=" + Arrays.toString(items) + "]";
	}

}
