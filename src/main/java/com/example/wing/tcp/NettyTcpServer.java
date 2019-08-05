package com.example.wing.tcp;


import com.example.wing.modbus.ModbusUtil;
import com.mongodb.internal.HexUtils;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.bytes.ByteArrayDecoder;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Component
public class NettyTcpServer {

    public NettyTcpServer() {
        initNettyTcpServer();
    }
    public void initNettyTcpServer() {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        NioEventLoopGroup boos = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();
        System.err.println(boos);
        System.err.println(worker);
        serverBootstrap.group(boos, worker)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    protected void initChannel(NioSocketChannel ch) {
                        ch.pipeline().addLast(new ByteArrayDecoder());
                        ch.pipeline().addLast(new SimpleChannelInboundHandler<byte[]>() {
                            @Override
                            protected void channelRead0(ChannelHandlerContext ctx, byte[] msg) {
                                /**
                                for (int i=0; i< msg.length; i++) {
                                    System.err.println(msg[i]);
                                }
                                 */


                                System.err.println(HexUtils.toHex(msg));
                                ModbusUtil modbusUtil = new ModbusUtil();
                                modbusUtil.decodeAdu(msg);
                            }
                        });
                    }
                })
                .bind(9000);
    }
}
