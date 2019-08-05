package com.example.wing.modbus;

public class ModbusReadCoil implements ModbusPdu{
    private int startAddress;
    private int coilQuantity;

    public ModbusReadCoil decodeModbusPdu(byte[] bytes) {
        this.startAddress = ((0xff & bytes[0])<<8) | bytes[1];
        System.err.println(this.startAddress);
        this.coilQuantity = ((0xff & bytes[2])<<8) | bytes[3];
        System.err.println(this.coilQuantity);
//        this.startAddress = Integer.parseInt(HexByteUtils.byteToHex(Arrays.copyOfRange(bytes, 0, 2)), 16);
//        this.coilQuanlities = Integer.parseInt(HexByteUtils.byteToHex(Arrays.copyOfRange(bytes, 2, 4)), 16);
        return this;
    }

    public int getCoilQuanlity() {
        return this.coilQuantity;
    }

    public int getStartAddress() {
        return this.startAddress;
    }

    @Override
    public String toString() {
        return "startAddress: " + this.startAddress + ", coilQuanlities: " + this.coilQuantity;
    }
}
