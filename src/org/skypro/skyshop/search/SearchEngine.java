package org.skypro.skyshop.search;

import org.skypro.skyshop.exception.BestResultNotFound;

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

    public Searchable searchBestResult(String search) throws BestResultNotFound {
        Searchable bestResult = null;
        int maxQty = 0;
        for (Searchable item : searchable) {
            int searchIndex = 0;
            int index = 0;
            int qty = 0;

            while (searchIndex != -1) {
                searchIndex = item.getSearchTerm().toLowerCase().indexOf(search.toLowerCase(), index);
                index = searchIndex + search.length();
                if (index >= search.length()) {
                    qty++;
                }
            }
            if (qty > maxQty) {
                maxQty = qty;
                bestResult = item;
            }

            }
        if (bestResult == null) {
            throw new BestResultNotFound("Поиск не принёс результата");
        }
        return bestResult;
    }
}
