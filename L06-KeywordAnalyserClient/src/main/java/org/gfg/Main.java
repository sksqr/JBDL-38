package org.gfg;

import com.google.gson.Gson;
import org.jbdl38.KeywordAnalyser;
import org.jbdl38.KeywordCount;
import org.jbdl38.KeywordCountAnalyser;
import org.jbdl38.NewKeywordAnalyser;

public class Main {
    public static void main(String[] args) {


        KeywordAnalyser keywordAnalyser = new KeywordCountAnalyser();
//        KeywordAnalyser keywordAnalyser = new NewKeywordAnalyser();

        keywordAnalyser.recordKeyword("phone");
        keywordAnalyser.recordKeyword("laptop");
        keywordAnalyser.recordKeyword("phone");
        keywordAnalyser.recordKeyword("iphone");
        keywordAnalyser.recordKeyword("ipad");

        for(String keyword : keywordAnalyser.getAllKeywords()){
            System.out.println(keyword);
        }


        Gson gson = new Gson();
        for(KeywordCount keywordCount : keywordAnalyser.getKeywordsWithCount()){
            System.out.println(gson.toJson(keywordCount));
        }


    }
}