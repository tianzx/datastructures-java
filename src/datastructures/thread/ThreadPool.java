package datastructures.thread;

import java.util.LinkedList;
import java.util.List;

public class ThreadPool {

	private int maxThread;
	private List threads;

	public ThreadPool() {
		this(10);
	}

	public ThreadPool(int maxThread) {
		this.maxThread = maxThread;
		threads = new LinkedList<>();
		for(int i=0;i<maxThread;i++){
			SimpleThread thread = new SimpleThread(i);
			threads.add(thread);
			thread.start();
		}
		System.err.println("thread pool created");
	}
	
	public void processTask(Task task){
		SimpleThread thread = getIdleThread();
		if(null!=thread){
			thread.setArgument(task);
			thread.setRunningFlag(true);
		}else{
			System.err.println("no active thread...");
		}
	}

	private synchronized SimpleThread getIdleThread() {
		for(int i=0;i<maxThread;i++){
			SimpleThread thread = (SimpleThread) threads.get(i);
			if(!thread.isAlive()) {
				return thread;
			}
		}
		return null;
	}
	
	
}
