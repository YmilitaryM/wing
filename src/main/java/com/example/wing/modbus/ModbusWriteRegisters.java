package com.example.wing.modbus;

import com.example.wing.common.utils.HexByteUtils;

import java.util.Arrays;

public class ModbusWriteRegisters implements ModbusPdu{
    private int startAddress;
    private int registerQuantity;
    private int byteNumber;
    private int[] registerValue;

    @Override
    public String toString() {
        return "startAddress: " + this.startAddress +
                " , registerQuantity: " + this.registerQuantity +
                " , byteNumber: " + this.byteNumber +
                " , registerValue :" + Arrays.toString(this.registerValue);
    }

    public ModbusWriteRegisters decodeModbusPdu(byte[] bytes) {
        this.startAddress = ((0xff & bytes[0])<<8) | bytes[1];
        this.registerQuantity = ((0xff & bytes[2])<<8) | bytes[3];
        this.byteNumber = bytes[4];

        byte[] newBytes = Arrays.copyOfRange(bytes, 5, bytes.length);
        registerValue = new int[this.byteNumber/2];
        for(int i = 0, j = 0 ; j < this.byteNumber/2;i++,j++) {
            this.registerValue[j] = ((0xff & newBytes[2*i])<<8) | newBytes[2*i+1];
        }

//        this.registerValue = Integer.parseInt(HexByteUtils.byteToHex(Arrays.copyOfRange(bytes, 5, 5 + this.byteNumber)), 16);
        return this;
    }

    public int getStartAddress() {
        return this.startAddress;
    }

    public int getRegisterQuantity() {
        return this.registerQuantity;
    }

    public int getByteNumber() {
        return byteNumber;
    }

    public int[] getRegisterValue() {
        return registerValue;
    }
}
