package com.example.wing.modbus;

import java.util.Arrays;

public class ModbusAdu {
    private byte slaveId;
    private byte functionCode;
    private byte[] data;
    //private byte[] crc;

    public ModbusAdu(byte[] bytes) {
        this.slaveId = bytes[0];
        this.functionCode = bytes[1];
        this.data = Arrays.copyOfRange(bytes, 2, bytes.length);
    }
    /**
    public ModbusAdu setAduData(byte[] bytes) {
        this.slaveId = bytes[0];
        this.functionCode = bytes[1];
        this.data = Arrays.copyOfRange(bytes, 2, bytes.length);
        return this;
    }
     */

    public byte[] getData() {
        return this.data;
    }

    public byte getSlaveId() {
        return this.slaveId;
    }

    public byte getFunctionCode() {
        return this.functionCode;
    }
}
