import java.lang.reflect.Array;

public class PercolationStats
{
	private int times;
	private double[] array;
    public PercolationStats(int N, int T)
    {
    	times = T;
    	if (N <= 0 || T <= 0)
    		{
    			throw new java.lang.IllegalArgumentException("out of bounds");
    		}

    	array = new double[T];
        for(int times = 0; times < T; times++)
        {
        	int opensites = 0;
        	Percolation per = new Percolation(N);
        	array = new double[T];
        	
        	while (!per.percolates())
        	{
        		int i = StdRandom.uniform(N);
        		int j = StdRandom.uniform(N);
        		if(!per.isOpen(i+1, j+1))
        		{
        			opensites ++;
        			per.open(i+1, j+1);
        		}
        	}
        	array[times] = (double) opensites/(double) (N*N);
        }
    }
    
    public double mean()
    {
        return StdStats.mean(array);
    }
    
    public double stddev()
    {
    	if(times == 1)
    	{
    		return Double.NaN;
    	}
    	return StdStats.stddev(array);
    }
    
    public double confidenceLo()
    {
       return mean() - ((1.96*stddev())/(Math.sqrt(times)));
    }
    
    public double confidenceHi()
    {
    	 return mean() + ((1.96*stddev())/(Math.sqrt(times)));
    }
    
    public static void main(String[] args)
    {
    	
        PercolationStats stats = new PercolationStats(5, 15);
        System.out.println("mean = " + stats.mean());
        System.out.println("stddev = "+ stats.stddev());
        System.out.println("95%% confidence interval = " + stats.confidenceLo() + ", " + stats.confidenceHi());
    	
    }
    
    
}