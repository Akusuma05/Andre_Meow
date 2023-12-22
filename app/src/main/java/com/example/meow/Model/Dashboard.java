package com.example.meow.Model;

public class Dashboard {
    String currentPage;
    String nextPage;

    public Dashboard(String currentPage, String nextPage) {
        this.currentPage = currentPage;
        this.nextPage = nextPage;
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public String getNextPage() {
        return nextPage;
    }

    public void setNextPage(String nextPage) {
        this.nextPage = nextPage;
    }
}
