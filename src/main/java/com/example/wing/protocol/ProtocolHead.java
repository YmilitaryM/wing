package com.example.wing.protocol;

import com.example.wing.protocol.tag.DataTag;

import java.util.Arrays;

public class ProtocolHead extends  Protocol {
    private String head;
    private byte[] data;


    public ProtocolHead decodeHead(DataTag dataTag, byte[] data) {
        String symbol = dataTag.getSymbol();
        if (symbol.equals("HE")) {
            //byte[] head = Arrays.copyOfRange(data, 0, 2);
            this.head = dataTag.getData();
            this.data = Arrays.copyOfRange(data, 2, data.length);
        }
        else if (symbol.equals("H")) {
            this.head = dataTag.getData();
            this.data = Arrays.copyOfRange(data, this.head.length(), data.length);
        }

        return this;

    }

    @Override
    public String toString() {
       return "head: " + this.head + " , data: " + this.data;
    }
}
