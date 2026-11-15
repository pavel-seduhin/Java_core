package org.skypro.skyshop.search;

import org.skypro.skyshop.exception.BestResultNotFound;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SearchEngine {


    private List<Searchable> searchable = new LinkedList<>();

    public void add(Searchable item) {
        searchable.add(item);
    }

    public List<Searchable> foundedItems = new ArrayList<>();

    public void search(String searchTerm) {
        Iterator<Searchable> iterator = searchable.iterator();
        while (iterator.hasNext()){
            Searchable item = iterator.next();
            if (item.getSearchTerm().contains(searchTerm)) {
                foundedItems.add(item);
            }
        }
    }

    public void printSearchResult(List<Searchable> foundedItems) {
        for (Searchable result : foundedItems) {
            System.out.println(result);
        }
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
