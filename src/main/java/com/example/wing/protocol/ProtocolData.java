package com.example.wing.protocol;

import com.example.wing.protocol.tag.DataTag;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ProtocolData {
    private Object decode;
    private byte[] data;

    public ProtocolData decodeData(DataTag dataTag, byte[] dataEncode) {

        String symbol = dataTag.getSymbol();
        int length = dataTag.getLength();
        String data = dataTag.getData();
        String order = dataTag.getOrder();
        if (symbol.equals("D?")) {

        }
        else if (symbol.equals("D")) {
            //int length = dataTag.getLength();
            this.decode = Arrays.copyOfRange(dataEncode, 0, length);
            this.data = Arrays.copyOfRange(dataEncode, length, dataEncode.length);
        }
        else if (symbol.equals("DE")) {
            this.decode = Arrays.copyOfRange(dataEncode, 0, length);
            this.data = Arrays.copyOfRange(dataEncode, length, dataEncode.length);

        }
        else if (symbol.equals("DEC")) {
            this.decode = Arrays.copyOfRange(dataEncode, 0, length);
            this.data = Arrays.copyOfRange(dataEncode, length, dataEncode.length);
        }
        else if (symbol.equals("DF")) {
            this.decode = Arrays.copyOfRange(dataEncode, 0, length);
            this.data = Arrays.copyOfRange(dataEncode, length, dataEncode.length);

        }
        else if (symbol.equals("GPS")) {

        }
        else if (symbol.equals("S")) {

        }
        else if (symbol.equals("SE")) {

        }
        else if (symbol.equals("SN")) {

        }
        else if (symbol.equals("T")) {

        }
        else if (symbol.equals("TE")) {

        }
        else if (symbol.equals("CRC16")) {

        }
        else if (symbol.equals("CRC8")) {

        }
        else {

        }
        return this;
    }
}
