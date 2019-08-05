package com.example.wing.protocol.utils;

import com.example.wing.protocol.explain.ExplainDataDescrible;

import java.util.List;

public class ProtocolUtils {
    public List explainTag(String tagString) {
        ExplainDataDescrible explainDataDescrible = new ExplainDataDescrible();
        List tagList = explainDataDescrible.explain(tagString);
        System.err.println(tagList);

        List dataTagList = explainDataDescrible.explainDataTag(tagList);
        System.err.println(dataTagList.toString());
        return dataTagList;
    }
}
