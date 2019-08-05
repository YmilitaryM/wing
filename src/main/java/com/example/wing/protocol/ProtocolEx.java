package com.example.wing.protocol;

import com.example.wing.protocol.tag.DataTag;
import com.example.wing.protocol.utils.ProtocolUtils;

import java.util.List;

public class ProtocolEx implements ProtocolBase {
    public byte[] decode(String string, byte[] data){
        ProtocolUtils protocolUtils = new ProtocolUtils();
        List  tagList = protocolUtils.explainTag(string);
        System.err.println(tagList.size());
        for(int i = 0; i < tagList.size(); i++) {
            DataTag dataTag = (DataTag) tagList.get(i);
            System.err.println(dataTag.toString());
            decode(dataTag, data);
        }
        return null;
    }

    private Object decode(DataTag dataTag, byte[] data) {
        System.err.println(dataTag.getSymbol());
        if (dataTag.getSymbol().equals("HE") || dataTag.getSymbol().equals("H")) {
            ProtocolHead protocolHead = new ProtocolHead();

             System.err.println(protocolHead.decodeHead(dataTag, data).toString());
             return null;
        }
        else {
            ProtocolData protocolData = new ProtocolData();
            System.err.println(protocolData);
            return protocolData.decodeData(dataTag, data);
        }

    }

}
