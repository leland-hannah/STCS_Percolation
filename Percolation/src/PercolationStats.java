import java.lang.reflect.Array;

public class PercolationStats
{
	private int times;
	private Percolation per;
	private double[] array;
	private double openSites = 0;
    public PercolationStats(int N, int T)
    {
    	
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
    	PercolationStats perlocation = new PercolationStats(20, 15);
    	
    }
    
    
}