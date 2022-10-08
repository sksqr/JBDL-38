package org.jbdl38;

import java.util.ArrayList;
import java.util.List;

public class KeywordAnalyserImpl implements KeywordAnalyser{

    private List<String> keywords;

    public KeywordAnalyserImpl() {
        this.keywords = new ArrayList<>();
    }

    @Override
    public void recordKeyword(String keyword) {
        keywords.add(keyword);
    }

    @Override
    public List<String> getAllKeywords() {
        return keywords;
    }
}
