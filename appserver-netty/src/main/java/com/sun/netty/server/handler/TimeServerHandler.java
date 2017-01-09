package com.sun.netty.server.handler;

import java.util.Date;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class TimeServerHandler extends ChannelHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		// TODO Auto-generated method stub
		//super.channelRead(ctx, msg);
		ByteBuf buf = (ByteBuf)msg;
		byte[] req = new byte[buf.readableBytes()];
		buf.readBytes(req);
		String body = new String(req, "UTF-8");
		System.out.println("The time server receive order : "+body);
		String currentTime = new Date(System.currentTimeMillis()).toString();
		ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
		ctx.write(resp);
		System.out.println("response :"+currentTime);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		//super.channelReadComplete(ctx);
		ctx.flush();
		System.out.println("read completed...");
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		// TODO Auto-generated method stub
		//super.exceptionCaught(ctx, cause);
		ctx.close();
		System.out.println("close completed...");
	}

}
