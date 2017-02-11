package ArraysAndString;

public class ZeroMatrix {

	/*
	Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
	column are set to 0.
	 */
	public static void main(String[] args) {
		int[][] matrix = new int[5][3];
		solution1(matrix);
	}

	private static void solution1(int[][] matrix) {

		int r=matrix.length, c = matrix[0].length, i=0,j=0;
		int[] rowMat = new int[r];
		int[] colMat = new int[c];
		
		for(i=0;i<r;i++){
			for(j=0;j<c;j++){
				if(matrix[i][j]==0){
					rowMat[i]=1;
					colMat[j]=1;
				} 
			}			
		}

		for(i=0;i<r;i++){
			for(j=0;j<c;j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		
		markZero(matrix,rowMat,colMat);
		
	}

	private static void markZero(int[][] matrix, int[] rowMat, int[] colMat) {
		int r=rowMat.length, c=colMat.length, i=0,j=0;
		
		for(i=0;i<r;i++){
			if(rowMat[i]==1){
				j=0;
				while(j<c){
					matrix[i][j]=0;
					j++;
				}
			}
		}
		
		i=0;
		for(i=0;i<c;i++){
			if(colMat[i]==1){
				j=0;
				while(j<r){
					matrix[j][i]=0;
					j++;
				}
			}
		}
	}
}
