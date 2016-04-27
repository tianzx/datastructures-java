package datastructures.thread.connPool.connPool1;

public class DBbean {

	private String driverName;
	private String url;
	private String userName;
	private String password;

	private String poolName;
	private int minConnection = 1;
	private int maxConnection = 10;

	private int initConnection = 5;
	
	private long connTimeOut = 1000;
	
	private int maxActiveConnections =100;
	
	private long connectionTimeOut = 1000*60*20;
	
	private boolean isCurrentConnection = true;
	
	private boolean isCheckPool = true;
	private long lazyCheck = 1000*60*60;
	private long periodCheck = 1000*60*60;
	
}
