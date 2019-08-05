package com.example.wing.protocol;

import org.omg.CORBA.Any;

public interface ProtocolBase {
     byte[] decode(String tagDescribe, byte[] data);

}
