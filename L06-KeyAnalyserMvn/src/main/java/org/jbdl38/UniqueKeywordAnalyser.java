package com.collections;

import java.util.*;

public class UniqueKeywordAnalyser implements KeywordAnalyser{

    private Set<String> keywords;

    public UniqueKeywordAnalyser() {
        this.keywords = new LinkedHashSet<>();
    }

    @Override
    public void recordKeyword(String keyword) {
        keywords.add(keyword);
    }

    @Override
    public List<String> getAllKeywords() {
        List<String> list = new ArrayList<>();
        list.addAll(keywords);
        return list;
    }
}
