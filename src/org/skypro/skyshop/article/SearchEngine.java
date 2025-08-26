package org.skypro.skyshop.article;

public class SearchEngine {
    private Article[] articles;

    public SearchEngine(Article[] articles) {
        this.articles = articles;
    }

    // Метод для поиска статей по ключевому слову и сохранения в массив
    public Article[] searchByKeyword(String keyword) {
        // Максимальный размер массива результатов — как у исходного массива
        Article[] result = new Article[articles.length];
        int count = 0; // Счётчик найденных элементов

        for (Article article : articles) {
            if (article.getSearchTerm().toLowerCase().contains(keyword.toLowerCase())) {
                result[count] = article;
                count++;
            }
        }

        // Возвращаем только ту часть массива, которая содержит найденные элементы
        Article[] finalResult = new Article[count];
        System.arraycopy(result, 0, finalResult, 0, count);
        return finalResult;
    }

    // Пример использования



    }

