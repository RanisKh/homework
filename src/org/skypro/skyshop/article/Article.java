package org.skypro.skyshop.article;

import java.util.Objects;

public final class Article implements Searchable{

    private final String title;
    private final String text;

    public Article(String title, String text) {
        this.title = title;
        this.text = text;
    }

    @Override
    public String toString() {
        return "Название статьи " + title + " Текст статьи " + text;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article that = (Article) o;
        return Objects.equals(title, that.title) && Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, text);
    }

    @Override
    public String searchTerm() {
        return toString();
    }

    @Override
    public String getName() {
        return title;
    }

    @Override
    public String getTypeContent() {
        return "ARTICLE";
    }
}
