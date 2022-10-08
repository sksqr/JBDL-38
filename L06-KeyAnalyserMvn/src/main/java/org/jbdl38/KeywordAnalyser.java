package org.jbdl38;

import java.util.List;

public interface KeywordAnalyser {

    public void recordKeyword(String keyword);

    public List<String> getAllKeywords();

    default List<KeywordCount> getKeywordsWithCount(){
        return null;
    }

}
