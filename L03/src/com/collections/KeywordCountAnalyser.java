package com.collections;

import java.util.*;

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

    @Override
    public List<KeywordCount> topTenSearches(){
        List<KeywordCount> list = new ArrayList<>();
//        for(String keyword : keywordCountMap.keySet()){
//            list.add(new KeywordCount(keyword, keywordCountMap.get(keyword)));
//        }
//        list.sort(new Comparator<KeywordCount>() {
//            @Override
//            public int compare(KeywordCount keywordCount1, KeywordCount keywordCount2) {
//                return keywordCount1.getCount() - keywordCount2.getCount();
//            }
//        }.reversed());
        //O(nlogn) + O(n)

        PriorityQueue<KeywordCount> minHeap = new PriorityQueue<>((keywordCount1, keywordCount2) -> keywordCount1.getCount()-keywordCount2.getCount());
        int i=0;
        for(String keyword : keywordCountMap.keySet()){
            if(i<2) {
                minHeap.add(new KeywordCount(keyword, keywordCountMap.get(keyword)));
            }
            else{
                KeywordCount top = minHeap.peek();
                if(top.getCount() < keywordCountMap.get(keyword)){
                    minHeap.poll();
                    minHeap.add(new KeywordCount(keyword, keywordCountMap.get(keyword)));
                }
            }
            i++;
        }
        list.addAll(minHeap);
        return list;
    }




}
