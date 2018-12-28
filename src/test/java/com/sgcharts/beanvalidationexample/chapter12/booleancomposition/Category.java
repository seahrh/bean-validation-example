package com.sgcharts.beanvalidationexample.chapter12.booleancomposition;

class Category {
    @PatternOrSize
    private String code;
    Category(String code) {
        this.code = code;
    }
}
