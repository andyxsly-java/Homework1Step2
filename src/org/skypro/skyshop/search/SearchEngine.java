package org.skypro.skyshop.search;

import java.util.*;
import java.util.Set;
import java.util.TreeSet;

public class SearchEngine {

    private final Set<Searchable> items = new HashSet<>();

    public void add(Searchable item) {
        items.add(item);
    }

    public Set<Searchable> search(String searchTerm) {
        Set<Searchable> results = new TreeSet<>(new SearchableComparator());

        for (Searchable item : items) {
            if (item.getSearchTerm()
                    .toLowerCase()
                    .contains(searchTerm.toLowerCase())) {

                results.add(item);
            }
        }

        return results;
    }
}


