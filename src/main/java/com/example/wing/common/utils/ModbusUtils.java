//package com.example.wing.common.utils;
//
//import com.serotonin.modbus4j.BatchRead;
//import com.serotonin.modbus4j.BatchResults;
//import com.serotonin.modbus4j.ModbusFactory;
//import com.serotonin.modbus4j.ModbusMaster;
//import com.serotonin.modbus4j.code.DataType;
//import com.serotonin.modbus4j.exception.ErrorResponseException;
//import com.serotonin.modbus4j.exception.ModbusInitException;
//import com.serotonin.modbus4j.exception.ModbusTransportException;
//import com.serotonin.modbus4j.ip.IpParameters;
//import com.serotonin.modbus4j.locator.BaseLocator;
//
//public class ModbusUtils {
//    static ModbusFactory modbusFactory;
//    /**
//     * static {
//        if (modbusFactory == null) {
//            modbusFactory = new ModbusFactory();
//        }
//    }*/
//
//
//    public static ModbusMaster getMaster() throws ModbusInitException {
//        IpParameters parameters = new IpParameters();
//        parameters.setHost("192.168.152.125");
//        parameters.setPort(1000);
//        ModbusMaster master = modbusFactory.createTcpMaster(parameters, true);
//        master.init();
//        return master;
//    }
//
//    public static Boolean readCoilStatus(int slaveId, int offset)
//            throws ModbusTransportException, ErrorResponseException, ModbusInitException {
//        // 01 Coil Status
//        BaseLocator<Boolean> baseLocator = BaseLocator.coilStatus(slaveId, offset);
//        Boolean value = getMaster().getValue(baseLocator);
//        return value;
//    }
//
//    public static Boolean readInputStatus(int slaveId, int offset)
//            throws ModbusTransportException, ErrorResponseException, ModbusInitException {
//        // 02 Input Status
//        BaseLocator<Boolean> loc = BaseLocator.inputStatus(slaveId, offset);
//        Boolean value = getMaster().getValue(loc);
//        return value;
//    }
//
//    public static Number readHoldingRegister(int slaveId, int offset, int dataType)
//            throws ModbusTransportException, ErrorResponseException, ModbusInitException {
//        // 03 Holding Register类型数据读取
//        BaseLocator<Number> loc = BaseLocator.holdingRegister(slaveId, offset, dataType);
//        Number value = getMaster().getValue(loc);
//        return value;
//    }
//
//    public static Number readInputRegisters(int slaveId, int offset, int dataType)
//            throws ModbusTransportException, ErrorResponseException, ModbusInitException {
//        // 04 Input Registers类型数据读取
//        BaseLocator<Number> loc = BaseLocator.inputRegister(slaveId, offset, dataType);
//        Number value = getMaster().getValue(loc);
//        return value;
//    }
//
//    public static void batchRead() throws ModbusTransportException, ErrorResponseException, ModbusInitException {
//
//        BatchRead<Integer> batch = new BatchRead<Integer>();
//
//        batch.addLocator(0, BaseLocator.holdingRegister(1, 1, DataType.FOUR_BYTE_FLOAT));
//        batch.addLocator(1, BaseLocator.inputStatus(1, 0));
//
//        ModbusMaster master = getMaster();
//
//        batch.setContiguousRequests(false);
//        BatchResults<Integer> results = master.send(batch);
//        System.out.println(results.getValue(0));
//        System.out.println(results.getValue(1));
//    }
//
//
//}
