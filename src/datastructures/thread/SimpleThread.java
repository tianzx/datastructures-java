package datastructures.thread;

public class SimpleThread extends Thread {

	private boolean runningFlag;
	private Task argument;

	public SimpleThread(int num) {
		this.runningFlag = false;
		System.err.println("thread " + num + " starting");

	}

	public synchronized void run() {
		try {
			while (true) {
				if (!runningFlag) {
					this.wait();
				} else {
					System.err.println("processing" + argument.toString());
					sleep(3000);
					System.err.println(argument.toString() + "proecssed");
					setRunningFlag(false);
				}
			}
		} catch (Exception e) {

		}
	}

	/**
	 * @return the runningFlag
	 */
	public boolean isRunningFlag() {
		return runningFlag;
	}

	synchronized void setRunningFlag(boolean flag) {
		this.runningFlag = flag;
		if (runningFlag) {
			this.notify();
		}
	}

	/**
	 * @return the argument
	 */
	public Task getArgument() {
		return argument;
	}

	/**
	 * @param argument
	 *            the argument to set
	 */
	public void setArgument(Task argument) {
		this.argument = argument;
	}
}
