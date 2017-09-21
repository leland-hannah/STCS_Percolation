public class Percolation
{           
	
	private int[][] singlePoint;
	private boolean[][] grid;
	private WeightedQuickUnionUF wu;
	private int vTop = 0;
	private int vBottom; 
	
    public Percolation(int n)
    {
    	grid = new boolean[n][n+1];
    	singlePoint = new int[n][n+1];
    	wu = new WeightedQuickUnionUF((n*n) + 2);
    	vBottom = (n*n) + 1;
//    	int inside = 1;
    	
//    	for(int i = 0; i < n; i++)
//    	{
//    		for(int j = 0; j < n; j++)
//    		{
//    			singlePoint[i][j] = inside;
//    			inside++;
//    			
//    		}
//    	}
    }

    public void open(int i, int j)
    {
    	grid[i][j] = true;
    	
    	if(i == 1)
    	{
    		wu.union(singlePoint[i][j], vTop);
    	}
    	if(grid[i+1][j])
    	{
    		wu.union(singlePoint[i][j], singlePoint[i+1][j]);
    	}
    	if(grid[i-1][j])
    	{
    		wu.union(singlePoint[i][j], singlePoint[i-1][j]);
    	}
    	if(grid[i][j+1])
    	{
    		wu.union(singlePoint[i][j], singlePoint[i][j+1]);
    	}
    	if(grid[i][j-1])
    	{
    		wu.union(singlePoint[i][j], singlePoint[i][j-1]);
    	}
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
//    	Percolation perlocation = new Percolation(20);
//    	perlocation.open(1, 5);
//    	PercolationVisualizer.draw(perlocation, 5);
    }
    
    
    
}
