package org.skypro.skyshop.search;

public class SearchEngine {

    private final Searchable[] items;
    private int index = 0;

    public SearchEngine(int size) {
        items = new Searchable[size];
    }

    public void add(Searchable item) {
        if (index < items.length) {
            items[index++] = item;
        }
    }

    public Searchable[] search(String text) {
        Searchable[] result = new Searchable[5];
        int count = 0;

        for (Searchable s : items) {
            if (s == null) continue;

            if (s.getSearchTerm().toLowerCase().contains(text.toLowerCase())) {
                result[count++] = s;
                if (count == 5) break;
            }
        }

        return result;
    }
}

