package com.basic.io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.nio.charset.Charset;

public class PipeTest {
	public static void main(String[] args) throws IOException {
		// 创建一个管道
		Pipe pipe = Pipe.open();
		final Pipe.SinkChannel psic = pipe.sink();
		final Pipe.SourceChannel psoc = pipe.source();

		Thread tPwriter = new Thread() {
			public void run() {
				try {
					// 创建一个线程，利用管道的写入口Pipe.SinkChannel类型的psic往管道里写入指定ByteBuffer的内容
					psic.write(ByteBuffer.wrap("Hello,Pipe!".getBytes("utf-8")));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		Thread tPreader = new Thread() {
			public void run() {
				int bbufferSize = 1024 * 2;
				ByteBuffer bbuffer = ByteBuffer.allocate(bbufferSize);
				try {
					// 创建一个线程，利用管道的读入口Pipe.SourceChannel类型的psoc将管道里内容读到指定的ByteBuffer中
					psoc.read(bbuffer);
					String str = new String(bbuffer.array(), "utf-8");
					System.out.println("Content:" + str);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		tPwriter.start();
		tPreader.start();
	}
}
