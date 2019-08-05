//package com.example.wing.common.utils;
//
//
//import com.digitalpetri.modbus.codec.Modbus;
//import com.digitalpetri.modbus.master.ModbusTcpMaster;
//import com.digitalpetri.modbus.master.ModbusTcpMasterConfig;
//import com.digitalpetri.modbus.requests.ReadCoilsRequest;
//import com.digitalpetri.modbus.requests.ReadDiscreteInputsRequest;
//import com.digitalpetri.modbus.requests.ReadHoldingRegistersRequest;
//import com.digitalpetri.modbus.requests.ReadInputRegistersRequest;
//import com.digitalpetri.modbus.responses.ReadCoilsResponse;
//import com.digitalpetri.modbus.responses.ReadDiscreteInputsResponse;
//import com.digitalpetri.modbus.responses.ReadHoldingRegistersResponse;
//import com.digitalpetri.modbus.responses.ReadInputRegistersResponse;
//import io.netty.buffer.ByteBuf;
//import io.netty.util.ReferenceCountUtil;
//import org.springframework.stereotype.Component;
//
//import java.util.concurrent.CompletableFuture;
//import java.util.concurrent.ExecutionException;
//
//
//@Component
//public class ModbusTcp {
//     ModbusTcpMaster modbusTcpMaster;
//
//    public ModbusTcp() throws Exception {
//        initModbusTcpMaster();
//        readCoils(1, 2, 1);
//    }
//
//    public void initModbusTcpMaster() {
//        if(modbusTcpMaster == null) {
//            ModbusTcpMasterConfig config = new ModbusTcpMasterConfig.Builder("192.168.152.125").setPort(1000).build();
//            modbusTcpMaster = new ModbusTcpMaster(config);
//        }
//    }
//
//    public void release() {
//        if(modbusTcpMaster != null) {
//            modbusTcpMaster.disconnect();
//        }
//        Modbus.releaseSharedResources();
//
//    }
//
//    public Number readHoldingRegisters(int address, int quantity, int unitId)
//            throws InterruptedException, ExecutionException {
//        Number result = null;
//        CompletableFuture<ReadHoldingRegistersResponse> future = modbusTcpMaster
//                .sendRequest(new ReadHoldingRegistersRequest(address, quantity), unitId);
//        ReadHoldingRegistersResponse readHoldingRegistersResponse = future.get();// 工具类做的同步返回.实际使用推荐结合业务进行异步处理
//        if (readHoldingRegistersResponse != null) {
//            ByteBuf buf = readHoldingRegistersResponse.getRegisters();
//            result = buf.readFloat();
//            ReferenceCountUtil.release(readHoldingRegistersResponse);
//        }
//        return result;
//    }
//
//    public  Number readInputRegisters(int address, int quantity, int unitId)
//            throws InterruptedException, ExecutionException {
//        Number result = null;
//        CompletableFuture<ReadInputRegistersResponse> future = modbusTcpMaster
//                .sendRequest(new ReadInputRegistersRequest(address, quantity), unitId);
//        ReadInputRegistersResponse readInputRegistersResponse = future.get();// 工具类做的同步返回.实际使用推荐结合业务进行异步处理
//        if (readInputRegistersResponse != null) {
//            ByteBuf buf = readInputRegistersResponse.getRegisters();
//            result = buf.readFloat();
//            ReferenceCountUtil.release(readInputRegistersResponse);
//        }
//        return result;
//    }
//
//    public  Boolean readCoils(int address, int quantity, int unitId)
//            throws InterruptedException, ExecutionException {
//        Boolean result = null;
//        CompletableFuture<ReadCoilsResponse> future = modbusTcpMaster.sendRequest(new ReadCoilsRequest(address, quantity),
//                unitId);
//        ReadCoilsResponse readCoilsResponse = future.get();// 工具类做的同步返回.实际使用推荐结合业务进行异步处理
//        if (readCoilsResponse != null) {
//            ByteBuf buf = readCoilsResponse.getCoilStatus();
//            result = buf.readBoolean();
//            ReferenceCountUtil.release(readCoilsResponse);
//        }
//        return result;
//    }
//
//    public  Boolean readDiscreteInputs(int address, int quantity, int unitId)
//            throws InterruptedException, ExecutionException {
//        Boolean result = null;
//        CompletableFuture<ReadDiscreteInputsResponse> future = modbusTcpMaster
//                .sendRequest(new ReadDiscreteInputsRequest(address, quantity), unitId);
//        ReadDiscreteInputsResponse discreteInputsResponse = future.get();// 工具类做的同步返回.实际使用推荐结合业务进行异步处理
//        if (discreteInputsResponse != null) {
//            ByteBuf buf = discreteInputsResponse.getInputStatus();
//            result = buf.readBoolean();
//            ReferenceCountUtil.release(discreteInputsResponse);
//        }
//        return result;
//    }
//
//
//}
