import java.lang.reflect.Array;

public class PercolationStats
{
	private int times;
	private Percolation per;
	private double[] array;
	private double openSites = 0;
    public PercolationStats(int N, int T)
    {
    	if (N <= 0 || T <= 0)
    		{
    			throw new java.lang.IllegalArgumentException("out of bounds");
    		}

    	
    	array = new double[T];
        for(int times = 0; times < T; times++)
        {
        	per = new Percolation(N);
        	
        	while (!per.percolates())
        	{
        		int i = StdRandom.uniform(N);
        		int j = StdRandom.uniform(N);
        		per.open(i, j);
        		openSites ++;
        	}
        	
        	array[times] = (double) openSites/ (double) (N*N);
        }
    }
    
    public double mean()
    {
        return StdStats.mean(array);
    }
    
    public double stddev()
    {
    	if(openSites == 1)
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
    	int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        PercolationStats stats = new PercolationStats(N, T);
        StdOut.printf("mean = ", stats.mean());
        StdOut.printf("stddev = ", stats.stddev());
        StdOut.printf("95%% confidence interval = ", stats.confidenceLo(), ", ", stats.confidenceHi());
    	
    }
    
    
}