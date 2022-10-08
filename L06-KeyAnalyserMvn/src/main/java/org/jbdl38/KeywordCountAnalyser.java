package org.jbdl38;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeywordCountAnalyser implements KeywordAnalyser{

    private Map<String,Integer> keywordCountMap;
    public KeywordCountAnalyser() {
        this.keywordCountMap = new HashMap<>();
    }

    @Override
    public void recordKeyword(String keyword) {
        if(keywordCountMap.containsKey(keyword)){
            keywordCountMap.put(keyword,keywordCountMap.get(keyword)+1);
        }
        else {
            keywordCountMap.put(keyword,1);
        }
    }



    @Override
    public List<String> getAllKeywords() {
        List<String> list = new ArrayList<>();
        list.addAll(keywordCountMap.keySet());
        return list;
    }

    @Override
    public List<KeywordCount> getKeywordsWithCount() {
        List<KeywordCount> list = new ArrayList<>();
        for(String keyword : keywordCountMap.keySet()){
            list.add(new KeywordCount(keyword, keywordCountMap.get(keyword)));
        }
        return list;
    }
}
