package com.example.wing.modbus;

import com.example.wing.common.utils.HexByteUtils;

import java.util.Arrays;

public class ModbusReadOrWriteRegisters implements ModbusPdu {
    private int readStartAddress;
    private int readQuantity;
    private int writeStartAddress;
    private int writeQuantity;
    private int writeByteNumber;
    private int registerValue;

    public ModbusReadOrWriteRegisters decodeModbusPdu(byte[] bytes) {
        this.readStartAddress = ((0xff & bytes[0])<<8) | bytes[1];
        this.readQuantity = ((0xff & bytes[2])<<8) | bytes[3];
        this.writeStartAddress = ((0xff & bytes[4])<<8) | bytes[5];
        this.writeQuantity = ((0xff & bytes[6])<<8) | bytes[7];
        this.writeByteNumber = bytes[8];
        this.registerValue = Integer.parseInt(HexByteUtils.byteToHex(Arrays.copyOfRange(bytes, 9, 9 + this.writeByteNumber)), 16);
        return this;
    }

    public int getReadStartAddress() {
        return readStartAddress;
    }

    public int getRegisterValue() {
        return registerValue;
    }

    public int getReadQuantity() {
        return readQuantity;
    }

    public int getWriteByteNumber() {
        return writeByteNumber;
    }

    public int getWriteQuantity() {
        return writeQuantity;
    }

    public int getWriteStartAddress() {
        return writeStartAddress;
    }

    @Override
    public String toString() {
        return "readStartAddress: " + this.readStartAddress +
                " , readQuantity: " + this.readQuantity +
                " , writeStartAddress: " + this.writeStartAddress +
                " , writeQuantity: " + this.writeQuantity +
                " , writeByteNumber" + this.writeByteNumber +
                " , registerValue: " + this.registerValue;
    }
}
