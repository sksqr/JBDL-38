package com.collections;

public class KeywordCount {

    private String keyword;
    private Integer count;

    public KeywordCount(String keyword, Integer count) {
        this.keyword = keyword;
        this.count = count;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "KeywordCount{" +
                "keyword='" + keyword + '\'' +
                ", count=" + count +
                '}';
    }
}
