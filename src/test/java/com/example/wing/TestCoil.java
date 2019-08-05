package com.example.wing;

import com.example.wing.modbus.ModbusPdu;
import com.example.wing.modbus.ModbusReadCoil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCoil {
    @Test
    public void ContextLoad() {
//        ModbusReadCoil modbusReadCoil = new ModbusReadCoil();
//        modbusReadCoil
        byte[] bytes = {1, 3, 0, 0, 0, 10, -17, -65, -67, -17, -65, -67};
        System.err.println(Arrays.toString(bytes));
//        ModbusReadCoil modbusReadCoil = new ModbusReadCoil();
//        ModbusPdu modbusPdu = modbusReadCoil.decodeModbusPdu(bytes);
//        System.err.println(modbusPdu.toString());
    }
}
