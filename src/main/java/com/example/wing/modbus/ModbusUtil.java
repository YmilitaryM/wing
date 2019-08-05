package com.example.wing.modbus;

import java.util.Arrays;

public class ModbusUtil {
    private int slaveId;
    private int functionCode;
    private Object object;

    public int getSlaveId() {
        return slaveId;
    }

    public int getFunctionCode() {
        return functionCode;
    }

    public Object getObject() {
        return object;
    }

    public ModbusUtil decodeAdu(byte[] bytes) {
//        System.err.println(ModbusCrc.verifyCrc(bytes));

        if (ModbusCrc.verifyCrc(bytes)) {
            ModbusAdu modbusAdu = new ModbusAdu(bytes);
            this.slaveId = modbusAdu.getSlaveId();
            this.functionCode = modbusAdu.getFunctionCode();
            byte[] data = modbusAdu.getData();
            System.err.println(Arrays.toString(data));
            System.err.println(this.functionCode);
            switch (this.functionCode) {
                case 1:
                    ModbusReadCoil modbusReadCoil = new ModbusReadCoil();
                    this.object = modbusReadCoil.decodeModbusPdu(data);
                    break;
                case 2:
                    ReadDiscreteInput readDiscreteInput = new ReadDiscreteInput();
                    this.object = readDiscreteInput.decodeModbusPdu(data);
                    break;
                case 3:
                    ReadHoldRegister readHoldRegister = new ReadHoldRegister();
                    this.object = readHoldRegister.decodeModbusPdu(data);
                    break;
                case 4:
                    ReadInputRegister readInputRegister = new ReadInputRegister();
                    this.object = readInputRegister.decodeModbusPdu(data);
                    break;
                case 5:
                    ModbusWriteCoil modbusWriteCoil = new ModbusWriteCoil();
                    this.object = modbusWriteCoil.decodeModbusPdu(data);
                    break;
                case 6:
                    ModbusWriteRegister modbusWriteRegister = new ModbusWriteRegister();
                    this.object = modbusWriteRegister.decodeModbusPdu(data);
                    break;
                case 15:
                    ModbusWriteCoils modbusWriteCoils = new ModbusWriteCoils();
                    this.object = modbusWriteCoils.decodeModbusPdu(data);
                    break;
                case 16:
                    ModbusWriteRegisters modbusWriteRegisters = new ModbusWriteRegisters();
                    this.object = modbusWriteRegisters.decodeModbusPdu(data);
                    break;
                case 22:
                    ModbusWriteMaskRegisters modbusWriteMaskRegisters = new ModbusWriteMaskRegisters();
                    this.object = modbusWriteMaskRegisters.decodeModbusPdu(data);
                    break;
                case 23:
                    ModbusReadOrWriteRegisters modbusReadOrWriteRegisters = new ModbusReadOrWriteRegisters();
                    this.object = modbusReadOrWriteRegisters.decodeModbusPdu(data);
                    break;
                case 43:
                    ModbusReadDeviceCode modbusReadDeviceCode = new ModbusReadDeviceCode();
                    this.object = modbusReadDeviceCode.decodeModbusPdu(data);
            }

            System.err.println(this.object);
        }
        return this;
    }
}
