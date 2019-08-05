package com.example.wing.protocol.tag;

public class DataTag extends BaseTag {
    private String symbol;
    private String data;
    private int length;
    private String order;

    public int getLength() {
        return length;
    }

    public String getData() {
        return data;
    }

    public String getOrder() {
        return order;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
       return  "symbol: " + this.symbol + " , data: " + this.data + " , length: " + this.length + " , order: " + this.order;
    }
}
