package org.skypro.skyshop.article;

public class BestResultNotFound extends Throwable {
    public BestResultNotFound(String search) {
    }

    public String BestResultNotFound(String searchTerm) {
        return ("Не найдено подходящего объекта для поискового запроса: " + searchTerm);
    }
}
