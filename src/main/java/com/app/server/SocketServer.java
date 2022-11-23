package com.app.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

	public static void main(String[] args) {
		try (
				ServerSocket server = new ServerSocket(10000);
				Socket sc = server.accept();
				// クライアントからの受取用
				BufferedReader reader = new BufferedReader(new InputStreamReader(sc.getInputStream()));
				// サーバーからクライアントへの送信用
				PrintWriter writer = new PrintWriter(sc.getOutputStream(), true);) {
			// クライアントから「exit」が入力されるまで無限ループ
			String line = null;
			while (true) {
				// クライアントから送信されたメッセージを取得
				line = reader.readLine();
				if (line.equals("exit")) {
					break;
				}
				System.out.println("クライアントからのメッセージ＝" + line);
				writer.println("Please input:");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
