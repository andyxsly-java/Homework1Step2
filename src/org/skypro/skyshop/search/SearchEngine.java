package org.skypro.skyshop.search;

import org.skypro.skyshop.exception.BestResultNotFound;

public class SearchEngine {
    private final Searchable[] items;
    private int size;

    public SearchEngine(int capacity) {
        this.items = new Searchable[capacity];
    }

    public void add(Searchable item) {
        items[size++] = item;
    }

    public Searchable bestResult(String search) throws BestResultNotFound {
        int maxCount = 0;
        Searchable best = null;

        for (int i = 0; i < size; i++) {
            String term = items[i].getSearchTerm();
            int count = 0;
            int index = term.indexOf(search);

            while (index != -1) {
                count++;
                index = term.indexOf(search, index + search.length());
            }

            if (count > maxCount) {
                maxCount = count;
                best = items[i];
            }
        }

        if (best == null) {
            throw new BestResultNotFound(search);
        }

        return best;
    }
}

