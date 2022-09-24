package com.collections;

import java.util.List;
import java.util.Set;

public interface KeywordAnalyser {

    public void recordKeyword(String keyword);

    public List<String> getAllKeywords();

    default List<KeywordCount> getKeywordsWithCount(){
        return null;
    }

    default List<KeywordCount> topTenSearches(){
        return null;
    }

}
