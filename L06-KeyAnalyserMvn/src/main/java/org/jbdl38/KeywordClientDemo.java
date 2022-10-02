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

        for(String keyword : keywordAnalyser.getAllKeywords()){
            System.out.println(keyword);
        }


        for(KeywordCount keywordCount : keywordAnalyser.getKeywordsWithCount()){
            System.out.println(keywordCount);
        }



    }
}
