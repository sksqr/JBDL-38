package com.collections;

public class KeywordClientDemo {

    public static void main(String[] args) {
//        KeywordAnalyser keywordAnalyser = new KeywordAnalyserImpl();
//        KeywordAnalyser keywordAnalyser = new UniqueKeywordAnalyser();
        KeywordAnalyser keywordAnalyser = new KeywordCountAnalyser();

        keywordAnalyser.recordKeyword("phone");
        keywordAnalyser.recordKeyword("laptop");
        keywordAnalyser.recordKeyword("phone");
        keywordAnalyser.recordKeyword("iphone");
        keywordAnalyser.recordKeyword("ipad");
        keywordAnalyser.recordKeyword("ipad");
        keywordAnalyser.recordKeyword("phone");

        for(String keyword : keywordAnalyser.getAllKeywords()){
            System.out.println(keyword);
        }


        for(KeywordCount keywordCount : keywordAnalyser.getKeywordsWithCount()){
            System.out.println(keywordCount);
        }

        System.out.println("Top 10:");
        for(KeywordCount keywordCount : keywordAnalyser.topTenSearches()){
            System.out.println(keywordCount);
        }



    }
}
