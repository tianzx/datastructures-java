package datastructures.simplesort;

public class BubbleSort {

	private int[] array;
	private int iIndex;
	private int Jindex;

	public BubbleSort(int[] array) {
		this.array = array;
	}

	public static void bubbleSort(int[] as) {
		/***
		 * i 用来控制比较次数
		 */
		for (int i = as.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (as[j] > as[j + 1]) {
					// 如果前面的数据比后面的大，应该交换
					swap(as, j, j + 1);
				}
			}
		}
	}

	public static void bubbleSort2(int[] as) {
		for (int i = 0; i < as.length - 1; i++) {
			for (int j = i + 1; j < as.length; j++) {
				if (as[i] > as[j]) {
					swap(as, i, j);
				}
			}
		}
	}

	public void bubbleSort3() {
		for (int i = 0; i < this.array.length; i++) {
			for (int j = i + 1; j < this.array.length; j++) {
				if (this.array[i] > this.array[j]) {
					this.iIndex = i;
					this.Jindex = j;
					swap2();
				}
			}
		}
	}

	private void swap2() {
		int temp = this.array[this.iIndex];
		this.array[this.iIndex] = this.array[this.Jindex];
		this.array[this.Jindex] = temp;

	}

	private static void swap(int[] as, int aIndex, int bIndex) {
		int temp = as[aIndex];
		as[aIndex] = as[bIndex];
		as[bIndex] = temp;
	}

	public static void main(String[] args) {
		// BubbleSort bs = new BubbleSort();
		int[] as = { 1, 4, 12, 8, 2, 6, 9, 5, 10, 123, 2, 3, 1, 3, 4, 5, 6, 7, 8 };
		BubbleSort bs = new BubbleSort(as);
		bs.bubbleSort3();
		bs.bubbleSort3();
		bs.bubbleSort3();
		// BubbleSort.bubbleSort2(as);
		for (int i : as)
			System.err.print(i + " ");
	}
}
