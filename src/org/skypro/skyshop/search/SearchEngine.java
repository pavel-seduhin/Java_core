package org.skypro.skyshop.search;

public class SearchEngine {


    private Searchable[] searchable;
    private int size;

    public SearchEngine(int size) {
        this.size = size;
        this.searchable = new Searchable[size];
    }

    static int itemCounter = 0;
    public void add(Searchable item) {
        if (searchable[itemCounter] == null) {
            searchable[itemCounter] = item;
        }
        itemCounter++;
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
