package org.skypro.skyshop.article;
import java.util.List;

public class SearchEngine {
    private List<Searchable> searchables;
    private Article[] articles;

    public SearchEngine(List<Searchable> searchables) {
        this.searchables = searchables;
    
    }
    public Searchable findMostRelevant(String search) throws BestResultNotFound {
        if (search == null || searchables == null || searchables.isEmpty()) {
            throw new BestResultNotFound(search);
        }

        Searchable mostRelevant = null;
        int maxCount = 0;

        for (Searchable searchable : searchables) {
            String searchTerm = searchable.getSearchTerm();
            if (searchTerm == null) {
                continue;
            }

            int count = countOccurrences(searchTerm, search);
            if (count > maxCount) {
                maxCount = count;
                mostRelevant = searchable;
            }
        }

        if (mostRelevant == null) {
            throw new BestResultNotFound(search);
        }

        return mostRelevant;
    }

 
    public SearchEngine() {

    }
    private int countOccurrences(String str, String sub) {
        if (sub.isEmpty()) {
            return 0;
        }

        int count = 0;
        int index = 0;
        while ((index = str.indexOf(sub, index)) != -1) {
            count++;
            index += sub.length();
        }
        return count;
    }


    public Article[] searchByKeyword(String keyword) {

        Article[] result = new Article[articles.length];
        int count = 0; 

        for (Article article : articles) {
            if (keyword.toLowerCase().contains(article.getSearchTerm().toLowerCase())) {
                result[count] = article;
                count++;
            }
        }


        Article[] finalResult = new Article[count];
        System.arraycopy(result, 0, finalResult, 0, count);
        return finalResult;
    }
}








