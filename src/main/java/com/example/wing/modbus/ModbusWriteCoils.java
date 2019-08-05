package com.example.wing.modbus;
import java.util.Arrays;

public class ModbusWriteCoils implements ModbusPdu{
    private int startAddress;
    private int outQuantity;
    private int byteNumber;
    private boolean[] outValue;

    @Override
    public String toString() {
        return "startAddress: " + this.startAddress +
                " , outQuantity: " + this.outQuantity +
                " , byteNumber: " + this.byteNumber +
                " , outValue: " + Arrays.toString(this.outValue);
    }

    public ModbusWriteCoils decodeModbusPdu(byte[] bytes) {
        this.startAddress = ((0xff & bytes[0])<<8) | bytes[1];
        //System.err.println(this.startAddress);
        this.outQuantity = ((0xff & bytes[2])<<8) | bytes[3];
        //System.err.println(this.outQuantity);
        this.byteNumber = bytes[4];
        /**
        int n = 0;
        if(0 != (this.byteNumber % 8)) {
            n = this.byteNumber + 1;
        }
        else {
            n = this.byteNumber;
        }
         */
        //outValue = new boolean[this.byteNumber*8+this.startAddress];
        outValue = new boolean[this.outQuantity];
        byte[] value = Arrays.copyOfRange(bytes, 5, 5 + this.byteNumber);
        int i, j, k;
        for (i =0; i < this.byteNumber; i++) {
            byte bytes1 = value[i];
            //System.err.println(bytes1);
            for(j = 0, k = 0; j < 8 && k < this.outQuantity; j++) {
                int power = power(2, j);
                //System.err.println(power);
                int turnValue = bytes1 & power;
                //System.err.println(turnValue);

                this.outValue[i*8 + j] = turnValue == power;

            }


        }
//        this.outValue = Integer.parseInt(HexByteUtils.byteToHex(Arrays.copyOfRange(bytes, 5, 5 + n)), 16);
        return this;
    }


    public int getStartAddress() {
        return this.startAddress;
    }

    public int getOutQuantity() {
        return this.outQuantity;
    }

    public int getByteNumber() {
        return this.byteNumber;
    }

    public boolean[] getOutValue() {
        return this.outValue;
    }

    public boolean getCoilStatus(int coilPosition) {
        int realCoilPosition = coilPosition - this.startAddress -1;
        return this.outValue[realCoilPosition];
    }

    private int power(int a, int b) {
        if (b==0)
            return 1;
        return a*power(a, b-1);

    }
}
