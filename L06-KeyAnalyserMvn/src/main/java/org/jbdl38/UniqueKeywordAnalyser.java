package org.jbdl38;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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
