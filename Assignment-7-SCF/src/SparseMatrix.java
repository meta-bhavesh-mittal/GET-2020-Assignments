/**
 * This class is used to perform various operations on matrix.
 * @author Bhavesh
 *
 */
public final class SparseMatrix
{
	private final int row[];
	private final int col[];
	private final int val[];
	private final int matrixRows;
	private final int matrixCols;
	int countNonZero = 0;

	public SparseMatrix(int matrix[][])
	{
		
		int index =-1;
		int index1=-1;
		int index2 =-1;
		this.matrixRows = matrix.length;
		this.matrixCols = matrix[0].length;

		for(int i = 0; i<matrix.length ;i++)
		{
			for(int j =0; j<matrix[0].length ; j++)
			{
				if(matrix[i][j] != 0)
				{
					countNonZero++;
				}
			}
		}
		this.row = new int[countNonZero];
		this.col = new int[countNonZero];
		this.val = new int[countNonZero];
		for(int i = 0; i<matrix.length ;i++)
		{
			for(int j =0; j<matrix[0].length ; j++)
			{
				if(matrix[i][j] != 0)
				{
					row[++index] = i;
					col[++index1] = j;
					val[++index2] = matrix[i][j];
				}
			}
		}
	}

	/**
	 * This method is used to get transpose of a matrix.
	 * @return it returns an array.
	 */
	public int[][] getTranspose()
	{
		int[][] transposeMatrix = new int[matrixRows][matrixCols];
		int temp;
		int trow[] = row.clone();
		int tcol[] = col.clone();
		for(int i = 0; i < trow.length;i++)
		{
			temp = trow[i];
			trow[i] = tcol[i];
			tcol[i] = temp;
		}
		for( int i =0 ;i< trow.length; i++)
		{
			transposeMatrix[trow[i]][tcol[i]] = val[i];
		}
		return transposeMatrix;
	}

	
	/**
	 * This method is used to check whether the matrix is symmetrical or not.
	 * @return it returns a boolean value.
	 */
	public boolean isSymmetrical()
	{
		int trow[] = col.clone();
		int tcol[] = row.clone();
		int Matrix[][] = new int[matrixRows][matrixCols];
		for( int i =0, j=0 ; i< row.length; i++,j++)
		{
			Matrix[row[i]][col[j]] = val[i];
		}
		int transpose[][] = getTranspose();
		for( int i =0 ;i <row.length;i++)
		{
			for( int j = 0;j < col.length;j++)
			{
				if(Matrix[i][j] != transpose[i][j])
				{
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * This method is used to add two sparse matrix.
	 * @param s1
	 * @return it returns a 2D matrix.
	 */
	public int[][] add(SparseMatrix s1)
	{
		if((matrixRows != s1.matrixRows) || (matrixCols != s1.matrixCols))
		{
			System.out.println("Addition is not possible.");
			throw new AssertionError();
		}
		int add[][] = new int[matrixRows][matrixCols];
		for( int i =0 ;( i< row.length); i++)
		{
			add[row[i]][col[i]] = val[i];
		}
		for( int i= 0;i<s1.row.length;i++)
		{
			add[s1.row[i]][s1.col[i]]+= s1.val[i];
		}
		return add;
	}


	/**
	 * This method is used to multiply two sparse matrix.
	 * @param s1
	 * @return It returns a matrix.
	 */
	public int[][] multiply(SparseMatrix s1)
    {
        if(this.matrixCols!=s1.matrixRows)
        {
            throw new AssertionError("Number of columns of first matrix is not equal to number of rows in the second Matrix");
        }
        int multi[][]=new int[this.matrixRows][s1.matrixCols];
        SparseMatrix s2=new SparseMatrix(s1.getTranspose());
        for(int i=0;i<this.countNonZero;i++)
        {
            for(int j=0;j<s2.countNonZero;j++)
            {
                if(this.col[i]==s2.col[j])
                {                
                    multi[row[i]][s2.row[j]]+=this.val[i]*s2.val[j];      
                }
            }
        }
        return multi;
    }
}
