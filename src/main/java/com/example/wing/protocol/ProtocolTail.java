package com.example.wing.protocol;

import com.example.wing.protocol.tag.DataTag;

import java.util.List;
import com.example.CommandChain;



public class ProtocolTail {

    public boolean decodeTail(List<DataTag> tagList, byte[] dataEncode) {

        //CommandChain commandChain = new CommandChain();
        DataTag dataTag = tagList.get(tagList.size());
        String symbol = dataTag.getSymbol();
        if (symbol.equals("CRC16")) {

        }

        else if (symbol.equals("CRC8")) {

        }

        else if (symbol.equals("t")) {

        }

        else if (symbol.equals("TE")) {

        }
        return  false;
    }


}
