package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

public class Article implements Searchable {

    private final String articleName;
    private final String articleText;

    public Article(String articleName, String articleText) {
        this.articleName = articleName;
        this.articleText = articleText;
    }

    @Override
    public String toString() {
        return getName() + "\n" + articleText;
    }

    @Override
    public String getSearchTerm() {
        return (this.articleName + "" + this.articleText);
    }

    @Override
    public String getName() {
        return this.articleName;
    }
    @Override
    public String getType() {
        return "ARTICLE";
    }

    @Override
    public void getStringRepresentation() {
        System.out.println(getName() + " - " + getType());
    }
}
