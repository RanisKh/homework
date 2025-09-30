package org.skypro.skyshop.article;

public interface Searchable {
    String searchTerm();

    String getName();

    String getTypeContent();

    default String getSearchTerm(){
        return getName()+ " " + getTypeContent();
    }
}