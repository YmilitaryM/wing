package com.example.wing.modbus;

public class ModbusWriteRegister implements ModbusPdu {
    private int registerAddress;
    private int registerValue;

    @Override
    public String toString() {
        return "registerAddress: " + this.registerAddress +
                " , registerValue: " + this.registerValue;
    }

    public ModbusWriteRegister decodeModbusPdu(byte[] bytes) {
        this.registerAddress = ((0xff & bytes[0])<<8) | bytes[1];
        this.registerValue = ((0xff & bytes[2])<<8) | bytes[3];
        return this;
    }

    public int getRegisterAddress() {
        return this.registerAddress;
    }

    public int getRegisterValue() {
        return this.registerValue;
    }
}
