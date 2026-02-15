package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

public class Article implements Searchable {

    private final String name;
    private final String text;

    public Article(String title, String text) {
        this.name = title;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return name + "\n" + text;
    }

    @Override
    public String getSearchTerm() {
        return toString();
    }

    @Override
    public String getSearchType() {
        return "ARTICLE";
    }

    @Override
    public String getSearchableName() {
        return name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(name, article.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
