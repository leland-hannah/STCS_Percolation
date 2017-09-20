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
    	int inside = 1;
    	
    	for(int i = 0; i < n; i++)
    	{
    		for(int j = 0; j < n; j++)
    		{
    			grid[i][j] = false;
    			singlePoint[i][j] = inside;
    			inside++;
    			
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
        	if(wu.find(vTop) == wu.find(singlePoint[i][j]))
        	{
        		return true;
        	}
    	}
        
        return false;
    }

    public boolean percolates()
    {
        if(wu.find(vTop) == wu.find(vBottom))
        {
        	return true;
        }
    	
    	return false;
    }
    
    
    public static void main(String[] args)
    {
    	Percolation perlocation = new Percolation(20);
    	perlocation.open(1, 6);
    	perlocation.open(2, 6);
    	perlocation.open(3, 6);
    	PercolationVisualizer.draw(perlocation, 19);
    }
    
    
    
}
