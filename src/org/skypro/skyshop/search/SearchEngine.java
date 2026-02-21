package org.skypro.skyshop.search;

import java.util.*;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SearchEngine {

    private final Set<Searchable> items = new HashSet<>();

    public void add(Searchable item) {
        items.add(item);
    }

    public Set<Searchable> search(String searchTerm) {

        return items.stream()
                .filter(item -> item.getSearchTerm()
                        .toLowerCase()
                        .contains(searchTerm.toLowerCase()))
                .collect(Collectors.toCollection(
                        () -> new TreeSet<>(new SearchableComparator())
                ));
    }
}


