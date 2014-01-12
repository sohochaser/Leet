package com.basic.io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.nio.charset.Charset;

public class PipeTest {
	public static void main(String[] args) throws IOException {
		// ����һ���ܵ�
		Pipe pipe = Pipe.open();
		final Pipe.SinkChannel psic = pipe.sink();
		final Pipe.SourceChannel psoc = pipe.source();

		Thread tPwriter = new Thread() {
			public void run() {
				try {
					// ����һ���̣߳����ùܵ���д���Pipe.SinkChannel���͵�psic���ܵ���д��ָ��ByteBuffer������
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
					// ����һ���̣߳����ùܵ��Ķ����Pipe.SourceChannel���͵�psoc���ܵ������ݶ���ָ����ByteBuffer��
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
