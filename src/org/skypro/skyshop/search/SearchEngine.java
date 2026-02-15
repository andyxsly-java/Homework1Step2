package org.skypro.skyshop.search;

import java.util.*;

public class SearchEngine {

    private final List<Searchable> items = new ArrayList<>();

    public void add(Searchable item) {
        items.add(item);
    }

    public TreeMap<String, Searchable> search(String searchTerm) {
        TreeMap<String, Searchable> results = new TreeMap<>();

        for (Searchable item : items) {
            if (item.getSearchTerm()
                    .toLowerCase()
                    .contains(searchTerm.toLowerCase())) {

                results.put(item.getSearchableName(), item);
            }
        }

        return results;
    }
}


