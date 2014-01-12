package com.basic.io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class Transfer {
	public static void main(String[] args) throws IOException {
		RandomAccessFile fromFile = new RandomAccessFile("J:/dev/data/demo.txt", "rw");
		FileChannel fromChannel = fromFile.getChannel();
		
		RandomAccessFile toFile = new RandomAccessFile("J:/dev/data/toFile.txt", "rw");
		FileChannel toChannel = toFile.getChannel();

		long position = 0;
		long count = fromChannel.size();

		toChannel.transferFrom(fromChannel, position,count);
		fromChannel.transferTo(position, count, toChannel);		
	}
}
