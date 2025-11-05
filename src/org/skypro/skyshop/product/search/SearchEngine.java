package org.skypro.skyshop.product.search;

import java.util.*;
import java.util.stream.Collectors;
import java.util.Objects;

public class SearchEngine {
    private static Set<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new HashSet<>();
    }


    public SearchEngine(int initialCapacity) {
        this.searchables = new HashSet<>(initialCapacity);
    }

    private static final Comparator<Searchable> LENGTH_THEN_NATURAL_COMPARATOR = (s1, s2) -> {
        int lenghtCompare = Integer.compare(
                s2.getName().length(),
                s1.getName().length()
        );

        if (lenghtCompare != 0) {
            return lenghtCompare;
        }
        return s1.getName().compareTo(s2.getName());
    };

    public static Set<Searchable> search(String query) {

        if (query == null || query.trim().isEmpty()) {
            return new TreeSet<>(LENGTH_THEN_NATURAL_COMPARATOR);
        }

        String LowerQuery = query.toLowerCase();

        return searchables.stream()
                .filter(Objects::nonNull)
                .filter(item -> item.getSearchTerm() != null)
                .filter(item -> item.getSearchTerm().toLowerCase().contains(LowerQuery))
                .collect(Collectors.toCollection(
                        ()-> new TreeSet<>(LENGTH_THEN_NATURAL_COMPARATOR)
                ));

    }

    public static boolean add(Searchable item) {
        if (item != null) {
            return searchables.add(item);
        }
        return false;
    }

    public void addAll(List<Searchable> items) {
        if (items != null) {
            for (Searchable item : items) {
                if (item != null) {
                    searchables.add(item);
                }
            }
        }
    }

    public boolean remove(Searchable item) {
        return searchables.remove(item);
    }

    public boolean contains(Searchable item) {
        return searchables.contains(item);
    }

    public int getSearchableCount() {
        return searchables.size();
    }

    public void clear() {
        searchables.clear();
    }

    public static List<Searchable> getSearchables() {
        List<Searchable> sortedList = new ArrayList<>(searchables);
        sortedList.sort(LENGTH_THEN_NATURAL_COMPARATOR);
        return sortedList;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SearchEngine that = (SearchEngine) o;
        return Objects.equals(searchables, that.searchables);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(searchables);
    }
}
