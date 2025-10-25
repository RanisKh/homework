package org.skypro.skyshop.article;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public interface Searchable {
    String searchTerm();

    String getName();

    public default Map<String, Searchable> searchKey(List<Searchable> searchableObjects) {
        Map<String, Searchable> sortedMap = new TreeMap<>();

        for (Searchable obj : searchableObjects) {
            sortedMap.put(obj.getName(), obj);
        }

        return sortedMap;
    }

    String getTypeContent();

    default String getSearchTerm(){
        return getName()+ " " + getTypeContent();
    }
}