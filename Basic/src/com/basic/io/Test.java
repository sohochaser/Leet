package com.basic.io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test {
	public static void main(String[] args) throws IOException {
		RandomAccessFile aFile = new RandomAccessFile("J:/dev/data/demo.txt",
				"rw");
		FileChannel inChannel = aFile.getChannel();

		// create buffer with capacity of 48 bytes
		ByteBuffer buf = ByteBuffer.allocate(480);

		int bytesRead = inChannel.read(buf); // read into buffer.
		while (bytesRead != -1) {
			System.out.println("Read " + bytesRead);
			buf.flip();// make buffer ready for read

			while (buf.hasRemaining()) {
				System.out.print((char) buf.get());// read 1 byte at a time
			}

			buf.clear();
			bytesRead = inChannel.read(buf);// make buffer ready for writing
		}
		aFile.close();
	}
}
