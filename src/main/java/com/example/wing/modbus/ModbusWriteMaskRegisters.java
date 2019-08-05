package com.example.wing.modbus;

public class ModbusWriteMaskRegisters implements ModbusPdu {
    private int address;
    private int andMask;
    private int orMask;

    @Override
    public String toString() {
        return "address: " + this.address +
                " , andMask: " + this.andMask +
                " , orMask: " + this.orMask;
    }

    public ModbusWriteMaskRegisters decodeModbusPdu(byte[] bytes) {
        this.address = ((0xff & bytes[0])<<8) | bytes[1];
        this.andMask = ((0xff & bytes[2])<<8) | bytes[3];
        this.orMask = ((0xff & bytes[4])<<8) | bytes[5];
        return this;
    }

    public int getAddress() {
        return address;
    }

    public int getAndMask() {
        return andMask;
    }

    public int getOrMask() {
        return orMask;
    }
}
