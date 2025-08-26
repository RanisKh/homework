package org.skypro.skyshop.article;

public class SearchEngine {
    private Article[] articles;

    public SearchEngine(Article[] articles) {
        this.articles = articles;
    }

    public SearchEngine() {

    }


    public Article[] searchByKeyword(String keyword) {

        Article[] result = new Article[articles.length];
        int count = 0; // Счётчик найденных элементов

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

