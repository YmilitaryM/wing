package com.example.wing.modbus;

public class ModbusWriteCoil implements ModbusPdu {
    private int outAddress;
    private int outValue;

    public ModbusWriteCoil decodeModbusPdu(byte[] bytes) {
        this.outAddress = ((0xff & bytes[0])<<8) | bytes[1];
        this.outValue = ((0xff & bytes[2])<<8) | bytes[3];
        return this;
    }

    public int getOutAddress() {
        return this.outAddress;
    }

    public int getOutValue() {
        return this.outValue;
    }

    @Override
    public String toString() {
        return "outAddress: " + this.outAddress +
                " , outValue: " + this.outValue;
    }
}
