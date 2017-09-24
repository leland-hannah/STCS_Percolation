public class PercolationStats
{
	private int times;
	private Percolation per;
	private int n;
	private double openSites = 0;
    public PercolationStats(int N, int T)
    {
    	n = N;
        per = new Percolation(N);
        for(int times = 0; times < T; times++)
        {
        	int i = (int)(Math.random()*n+1);
        	int j = (int)(Math.random()*n+1);
        	per.open(i, j);
        	openSites ++;
        }
    }
    
    public double mean()
    {
        return openSites/times;
    }
    
    public double stddev()
    {
        double top = Math.pow((openSites-mean()), 2);
        return top/(times -1);
    }
    
    public double confidenceLo()
    {
       return mean() - ((1.96*Math.sqrt(stddev()))/(Math.sqrt(times)));
    }
    
    public double confidenceHi()
    {
    	 return mean() + ((1.96*Math.sqrt(stddev()))/(Math.sqrt(times)));
    }
}