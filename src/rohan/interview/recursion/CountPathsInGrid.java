package rohan.interview.recursion;

public class CountPathsInGrid {

	public static void main(String[] args) {
		System.out.println(countPaths(1, 1, 3, 4));
	}

	private static int countPaths(int fromX, int fromY, int toX, int toY) {
		if ((fromX > toX) || (fromY > toY)) {
			return 0;
		}
		
		if ((fromX == toX) && (fromY == toY)) {
			return 1;
		}		
		
		int countOfPaths = countPaths(fromX + 1, fromY, toX, toY) +
						   countPaths(fromX, fromY + 1, toX, toY);
		
		return countOfPaths;
	}
}
