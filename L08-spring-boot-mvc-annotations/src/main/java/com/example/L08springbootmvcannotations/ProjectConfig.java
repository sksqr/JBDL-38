package com.example.L08springbootmvcannotations;

import org.jbdl38.KeywordAnalyser;
import org.jbdl38.KeywordAnalyserImpl;
import org.jbdl38.UniqueKeywordAnalyser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {

    @Bean("keywordAnalyserImpl")
    @Primary
    public KeywordAnalyser getKeywordAnalyser(){
        return new KeywordAnalyserImpl();
    }

    @Bean("uniqueKeywordAnalyser")
    public KeywordAnalyser getUniqueKeywordAnalyser(){
        return new UniqueKeywordAnalyser();
    }


}
