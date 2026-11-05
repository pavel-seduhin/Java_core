package org.skypro.skyshop.search;

public interface Searchable {

    String getSearchTerm();
    String getType();
    String getName();

    default void getStringRepresentation() {
        System.out.println(getName() + "-" + getType());
    }
}
