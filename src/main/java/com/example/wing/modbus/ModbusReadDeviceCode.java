package com.example.wing.modbus;

public class ModbusReadDeviceCode {
    private int type;
    private int readDeviceCode;
    private int id;

    public ModbusReadDeviceCode decodeModbusPdu(byte[] bytes) {
        this.type = bytes[0];
        this.readDeviceCode = bytes[1];
        this.id = bytes[2];
        return this;
    }

    public int getId() {
        return id;
    }

    public int getReadDeviceCode() {
        return readDeviceCode;
    }

    public int getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Type: " + this.type  + " , ReadDeviceCode: " + this.readDeviceCode + " , Id: " + this.id;
    }
}
