package com.example.wing.common.utils;

import io.swagger.models.auth.In;

import java.util.Arrays;

public class ModbusDecoder {
    public void decode(byte[] bytes) {
        System.err.println(Arrays.toString(bytes));
        System.err.println(bytes[0]);
        System.err.println(bytes[1]);
        byte[] address = new byte[2];
        byte[] quanlity = new byte[2];
        byte[] andMask = new byte[2];
        byte[] orMask = new byte[2];
        int number = 0 ;
        if (1 == bytes[1] || 2 == bytes[1] || 3 == bytes[1] || 4 == bytes[1]
            || 5 == bytes[1] || 6 == bytes[1]) {
            address = Arrays.copyOfRange(bytes, 2, 4);
            quanlity = Arrays.copyOfRange(bytes, 4, 6);
        }
        else if (15 == bytes[1])  {
            address = Arrays.copyOfRange(bytes, 2, 4);
            quanlity = Arrays.copyOfRange(bytes, 4, 6);
            number = bytes[6];
            int leftNumric = number % 8;
            int n = 0;
            if(leftNumric != 0) {
                n = number + 1;
            }
            else {
                n = number;
            }
            byte[] out = Arrays.copyOfRange(bytes, 7, 7 + n);
            System.err.println(Integer.parseInt(HexByteUtils.byteToHex(out), 16));

        }
        else if (16 == bytes[1] || 23 == bytes[1]) {
            address = Arrays.copyOfRange(bytes, 2, 4);
            quanlity = Arrays.copyOfRange(bytes, 4, 6);
            number = bytes[6];
            byte[] out = Arrays.copyOfRange(bytes, 7, 7 + number);
            System.err.println(Integer.parseInt(HexByteUtils.byteToHex(out), 16));
        }
        else if (22 == bytes[1]) {
            address = Arrays.copyOfRange(bytes, 2, 4);
            andMask = Arrays.copyOfRange(bytes, 4, 6);
            orMask = Arrays.copyOfRange(bytes, 6, 8);
        }
        else if (43 == bytes[1]) {
            int mType = bytes[2];
            int readDeviceId = bytes[3];
            int id = bytes[4];
            System.err.println(mType);
            System.err.println(readDeviceId);
            System.err.println(id);
        }
        else {
            System.err.println("error function code!");
        }

        System.err.println(Integer.parseInt(HexByteUtils.byteToHex(address), 16));
        System.err.println(Integer.parseInt(HexByteUtils.byteToHex(quanlity), 16));
        System.err.println(number);
        System.err.println(Integer.parseInt(HexByteUtils.byteToHex(andMask), 16));
        System.err.println(Integer.parseInt(HexByteUtils.byteToHex(orMask), 16));


//        byte[] byteArray = Arrays.copyOfRange(bytes, 2, bytes.length - 2);
//        System.err.println(Arrays.toString(byteArray));

//        byte[] byteCrc = new byte[]{
//                bytes[254], bytes[255]
//        };
//        System.err.println(Arrays.toString(byteCrc));

    }
}
