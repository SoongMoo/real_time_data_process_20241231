package webSocketServer;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

public class MyWebSocketServer extends WebSocketServer{
	List<WebSocket> connections = new ArrayList<WebSocket>();
	public static void main(String[] args) {
		InetSocketAddress address = new InetSocketAddress("192.168.22.60", 1234);
		MyWebSocketServer server = new MyWebSocketServer(address);
		server.start();
	}
	public MyWebSocketServer(InetSocketAddress address) {
		super(address);
	}
	@Override
	public void onOpen(WebSocket conn, ClientHandshake handshake) {
		// TODO Auto-generated method stub
		connections.add(conn);
		conn.send("Welcome to the WebSocket server!");
		System.out.println("onOpen : " + conn.getRemoteSocketAddress());
	}
	@Override
	public void onClose(WebSocket conn, int code, String reason, boolean remote) {
		connections.remove(conn);
		System.out.println("onClose : " + conn.getRemoteSocketAddress());
	}
	@Override
	public void onMessage(WebSocket conn, String message) {
		for(WebSocket connection : connections) {
				connection.send(conn.getRemoteSocketAddress() +" : " + message);
		}
	}
	@Override
	public void onError(WebSocket conn, Exception ex) {
		ex.printStackTrace();		
	}
	@Override
	public void onStart() {
		System.out.println("WebSocket Server started successfully.");				
	}
}
