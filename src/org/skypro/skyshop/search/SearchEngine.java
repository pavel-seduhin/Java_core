package org.skypro.skyshop.search;

public class SearchEngine {


    private Searchable[] searchable;

    public SearchEngine(int size) {
        this.searchable = new Searchable[size];
    }

    public void add(Searchable item) {
        for (int i = 0; i < searchable.length; i++) {
            if (searchable[i] == null) {
                searchable[i] = item;
                break;
            }
        }
    }

    public Searchable[] search(String searchTerm) {
        Searchable[] foundedItems = new Searchable[5];
        int counterOfFoundedItems = 0;
        for (Searchable item : searchable) {
            if (counterOfFoundedItems == 5) {
                break;
            }
            if (item == null) {
                continue;
            }
            if (item.getSearchTerm().contains(searchTerm)) {
                foundedItems[counterOfFoundedItems] = item;
                counterOfFoundedItems++;
            }
        }
        return foundedItems;
    }
}
