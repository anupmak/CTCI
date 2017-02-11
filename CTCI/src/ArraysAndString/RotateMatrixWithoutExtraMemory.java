package ArraysAndString;

public class RotateMatrixWithoutExtraMemory {

	/*
	 Given an image represented by an NxN matrix, where each pixel in the image is 4
	bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
	 */

	static int[][] matrix;
	static int n;
	static int r;
	static int c;
	static int top;
	static int right;
	static int bottom;
	static int left;

	public static void main(String[] args) {
		r=c=n= 5;
		matrix = new int[n][n];
		matrix[0][0] = 1; matrix[0][1] = 2; matrix[0][2] = 3; matrix[0][3] = 4; matrix[0][4] = 5;
		matrix[1][0] = 6; matrix[1][1] = 7; matrix[1][2] = 8; matrix[1][3] = 9; matrix[1][4] = 10;
		matrix[2][0] = 11; matrix[2][1] = 12; matrix[2][2] = 13; matrix[2][3] = 14; matrix[2][4] = 15;
		matrix[3][0] = 16; matrix[3][1] = 17; matrix[3][2] = 18; matrix[3][3] = 19; matrix[3][4] = 20;
		matrix[4][0] = 21; matrix[4][1] = 22; matrix[4][2] = 23; matrix[4][3] = 24; matrix[4][4] = 25;

		printMatrix();
		solution1();
		printMatrix();
	}

	private static void solution1() {		
		int s=0, e=0;
		for(int i=0; i<r/2; i++){
			s=i;
			e=r-i-1;
			for(int j=s ;j<e; j++){
				
				top = matrix[s][j];
				right = matrix[j][e];
				bottom = matrix[e][e-j+s];
				left = matrix[e-j+s][s];

				matrix[j][e] = top;
				matrix[e][e-j+s] = right;
				matrix[e-j+s][s] = bottom;
				matrix[s][j] = left;
			}
		}
	}

	private static void printMatrix() {
		System.out.println("\nPrinting matrix");
		for(int i =0;i<r;i++){
			for(int j =0;j<c;j++)
				System.out.print(matrix[i][j] + "	");
			System.out.println();
		}
	}

}
