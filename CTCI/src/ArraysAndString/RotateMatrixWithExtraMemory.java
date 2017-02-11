package ArraysAndString;

public class RotateMatrixWithExtraMemory {

	/*
	 Given an image represented by an NxN matrix, where each pixel in the image is 4
	bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
	*/

	static int[][] matrix;
	static int n;
	static int r;
	static int c;
	static int[] top;
	static int[] right;
	static int[] bottom;
	static int[] left;
	
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
		for(int i=0;i<r/2;i++){
			
			s=i;
			e=r-i-1;
			int len = e-s+1;
						
			top = new int[len];
			right = new int[len];
			bottom = new int[len];
			left = new int[len];

			top=getMatX(top,s,s,e);
			right=getMatY(right,s,e,e);
			bottom=getMatX(bottom,e,s,e);
			left=getMatY(left,s,e,s);
						
			rotateToY(top,s,e,e);
			rotateToX(right,e,s,e);
			rotateToY(bottom,s,e,s);
			rotateToX(left,s,s,e);
		}
	}

	private static void rotateToY(int[] mat, int s, int e, int c) {
		for(int j=0; j<(e-s+1);j++) matrix[j+s][c]=mat[j];
	}

	private static void rotateToX(int[] mat, int r, int s, int e) {
		for(int j=0; j<(e-s+1);j++) matrix[r][j+s]=mat[j];
	}

	private static int[] getMatX(int[] mat, int r, int s, int e) {
		for(int i=0; i<(e-s+1); i++) mat[i]=matrix[r][i+s];
		return mat;
	}

	private static int[] getMatY(int[] mat, int s, int e, int c) {
		for(int i=0; i<(e-s+1); i++) mat[i]=matrix[e-i][c];
		return mat;
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
