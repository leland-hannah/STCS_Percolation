public class Percolation
{           
	
	private int[][] singlePoint;
	private boolean[][] grid;
	private WeightedQuickUnionUF wu;
	private int vTop = 0;
	private int vBottom; 
	
    public Percolation(int n)
    {
    	grid = new boolean[n][n];
    	singlePoint = new int[n][n];
    	wu = new WeightedQuickUnionUF((n*n) + 2);
    	vBottom = (n*n) + 1;
    	
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
        	if(wu.find(vTop) == wu.find())
        	{
        		
        	}
        	
        }
        return false;
    }

    public boolean percolates()
    {
        return false;
    }
    
    
    public static void main(String[] args)
    {
    	Percolation perlocation = new Percolation(4);
    	
    	
    	
    }
    
    
    
}
