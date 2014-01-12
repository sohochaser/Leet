package com.basic.io;

import java.io.IOException;
import java.nio.Buffer;
import java.nio.IntBuffer;

public class NIOBuffer {
	public static void main(String[] args) throws IOException {
		IntBuffer ib = IntBuffer.allocate(5);

		int k = 2;
		for (int i = 0; i < 5; i++) {
			ib.put(i);
			print(ib);

			if (k == i) {
				System.out.println("------------------ " + k);
				ib.flip();// Write mode to read mode
				print(ib);
				ib.mark();
				while (ib.hasRemaining()) {
					// System.out.println("V\t"+ib.get());
					ib.get();
					//print(ib);
				}
				print(ib);
				System.out.println("Reset");
				ib.reset();
				print(ib);
				System.out.println("Rewind");
				ib.rewind();//position to zero, and limit not change
				print(ib);
				System.out.println("Compact");
				ib.compact();
				print(ib);
				ib.put(100);
				print(ib);
				System.out.println("Clear");
				ib.clear();				
				print(ib);
				ib.put(1);
				print(ib);
				System.out.println("-----------");
			}
		}
	}

	private static void print(Buffer ib) {
		System.out.println(ib.position() + "\t" + ib.limit() + "\t"
				+ ib.capacity());
	}
}
