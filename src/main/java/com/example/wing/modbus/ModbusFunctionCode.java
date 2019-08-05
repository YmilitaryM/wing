package com.example.wing.modbus;

public class ModbusFunctionCode {
    // 1=======> 读线圈
    public static final byte READ_COILS = 1;
    // 2=======> 读离散量输入
    public static final byte READ_DISCRETE_INPUTS = 2;
    // 3=======> 读保持寄存器
    public static final byte READ_HOLDING_REGISTERS = 3;
    // 4=======> 读输入寄存器
    public static final byte READ_INPUT_REGISTERS = 4;
    // 5=======> 写单个线圈
    public static final byte WRITE_COIL = 5;
    // 6=======> 写单个寄存器
    public static final byte WRITE_REGISTER = 6;
    //
    //public static final byte READ_EXCEPTION_STATUS = 7;
    // 15======> 写多个线圈
    public static final byte WRITE_COILS = 15;
    // 16======> 写多个寄存器
    public static final byte WRITE_REGISTERS = 16;
    //
    //public static final byte REPORT_SLAVE_ID = 17;
    // 22======> 屏蔽写寄存器
    public static final byte WRITE_MASK_REGISTER = 22;
    // 23======> 读/写多个寄存器
    public static final byte READ_OR_WRITE_REGISTERS = 23;

    // 43======> 读设备识别码
    public static  final byte READ_DEVICE_CODE = 43;

    public ModbusFunctionCode() {

    }

}
