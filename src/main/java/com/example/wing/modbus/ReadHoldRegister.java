package com.example.wing.modbus;

public class ReadHoldRegister implements ModbusPdu {
    private int startAddress;
    private int holdRegisterQuantity;

    @Override
    public String toString() {
        return "startAddress: " + this.startAddress +
                " , holdRegisterQuantity: " + this.holdRegisterQuantity;
    }

    public ReadHoldRegister decodeModbusPdu(byte[] bytes) {
        this.startAddress = ((0xff & bytes[0])<<8) | bytes[1];
        this.holdRegisterQuantity = ((0xff & bytes[2])<<8) | bytes[3];
        return this;
    }

    public int getStartAddress() {
        return this.startAddress;
    }

    public int getHoldRegisterQuanlities() {
        return this.holdRegisterQuantity;
    }
}
