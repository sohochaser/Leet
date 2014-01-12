package com.basic.io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileTest {

	public static void main(String[] args) throws IOException {
		RandomAccessFile aFile = new RandomAccessFile("J:/dev/data/write.txt",
				"rw");
		FileChannel channel = aFile.getChannel();

		String newData = "New String to write to file..."
				+ System.currentTimeMillis();

		ByteBuffer buf = ByteBuffer.allocate(48);
		buf.clear();
		buf.put(newData.getBytes());

		buf.flip();

		long pos = channel.position()+channel.size();
		channel.position(pos +123);
		
		while (buf.hasRemaining()) {
			channel.write(buf);
		}
		channel.close();
		aFile.close();
		
		ServerSocket s;
	}

}
