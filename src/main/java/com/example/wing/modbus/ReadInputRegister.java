package com.example.wing.modbus;

public class ReadInputRegister implements ModbusPdu {
    private int startAddress;
    private int inputRegisterQuantity;

    @Override
    public String toString() {
        return "startAddress: " + this.startAddress +
                " , inputRegisterQuantity: " + this.inputRegisterQuantity;
    }

    public ReadInputRegister decodeModbusPdu(byte[] bytes) {
        this.startAddress = ((0xff & bytes[0])<<8) | bytes[1];
        this.inputRegisterQuantity = ((0xff & bytes[2])<<8) | bytes[3];
        return this;
    }

    public int getStartAddress() {
        return this.startAddress;
    }

    public int getInputRegisterQuanlity() {
        return this.inputRegisterQuantity;
    }
}
