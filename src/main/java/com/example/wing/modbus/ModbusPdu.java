package com.example.wing.modbus;

public interface ModbusPdu {
     ModbusPdu decodeModbusPdu(byte[] bytes);
}
