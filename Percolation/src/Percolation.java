public class Percolation
{           
	
	private int[][] singlePoint;
	private boolean[][] grid;
	private WeightedQuickUnionUF wu;
	private int vTop = 0;
	private int vBottom; 
	private int size;
    public Percolation(int n)
    {
    	size = n;
    	grid = new boolean[n][n];
    	singlePoint = new int[n][n];
    	wu = new WeightedQuickUnionUF((n*n) + 2);
    	vBottom = (n*n) + 1;
    	int inside = 1;
    	
    	for(int i = 0; i < n; i++)
    	{
    		for(int j = 0; j < n; j++)
    		{
    			singlePoint[i][j] = inside;
    			inside++;
    			
    		}
    	}
    }
    public boolean transfer(int i, int j)
    {
    	return grid[i-1][j-1];
    }
    
    public int IntExchange(int i, int j)
    {
    	return size * (i - 1) + j;
    }
    
    public void open(int i, int j)
    {
    	grid[i-1][j-1] = true;
    	
    	if(i == 1)
    	{
    		wu.union(IntExchange(i, j), vTop);
    	}
    	if(i == size)
    	{
    		wu.union(IntExchange(i, j), vBottom);
    	}
    	if(i > 1 && transfer(i-1, j))
    	{
    		wu.union(IntExchange(i, j), IntExchange(i-1, j));
    	}
    	if( i < size && transfer(i+1, j))
    	{
    		wu.union(IntExchange(i, j), IntExchange(i+1, j));
    	}
    	if(j > 1 && transfer(i, j-1))
    	{
    		wu.union(IntExchange(i, j), IntExchange(i, j-1));
    	}
    	if(j < size && transfer(i, j+1))
    	{
    		wu.union(IntExchange(i, j), IntExchange(i, j+1));
    	}
    }

    public boolean isOpen(int i, int j)
    {
    	return transfer(i, j);
    }

    public boolean isFull(int i, int j)
    {
        	if(wu.connected(vTop, IntExchange(i, j)))
        	{
        		return true;
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
    	perlocation.open(1, 5);
    	perlocation.open(2, 5);
    	perlocation.open(3, 5);
    	perlocation.open(4, 5);
    	perlocation.open(5, 5);
    	PercolationVisualizer.draw(perlocation, 5);
    }
    
    
    
}
