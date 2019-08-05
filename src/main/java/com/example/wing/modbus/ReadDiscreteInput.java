package com.example.wing.modbus;

public class ReadDiscreteInput implements ModbusPdu {
    private int startAddress;
    private int inputQuantity;

    @Override
    public String toString() {
        return "startAddress: " + this.startAddress +
                " , inputQuantity: " + this.inputQuantity;
    }

    public ReadDiscreteInput decodeModbusPdu(byte[] bytes) {
        this.startAddress = ((0xff & bytes[0])<<8) | bytes[1];
        this.inputQuantity = ((0xff & bytes[2])<<8) | bytes[3];
        return this;
    }

    public int getStartAddress() {
        return this.startAddress;
    }

    public  int getInputQuanlity() {
        return this.inputQuantity;
    }

}
