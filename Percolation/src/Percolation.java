public class Percolation
{           
	
	private int[][] singlePoint;
	private boolean[][] grid;
	
	
    public Percolation(int n)
    {
    	grid = new boolean[n][n];
    	singlePoint = new int[n][n];
    	
    	for(int i = 0; i < n; i++)
    	{
    		for(int j = 0; j < n; j++)
    		{
    			grid[i][j] = false;
    		}
    	}
    }

    public void open(int i, int j)
    {
    	grid[i][j] = true;
    }

    public boolean isOpen(int i, int j)
    {
    	return grid[i][j];
    }

    public boolean isFull(int i, int j)
    {
        if(grid[i][j])
        {
        	
        	
        }
        return false;
    }

    public boolean percolates()
    {
        return false;
    }
    
    
    public static void main(String[] args)
    {
    	Percolation perlocation = new Percolation(5);
    	
    	
    	
    }
    
    
    
}
