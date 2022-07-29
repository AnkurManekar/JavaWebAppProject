import java.util.Scanner;

public class Average {
	public static void main(String args[])
	  {
		int i = 0;
		float sum=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Backend Language");
		int n=sc.nextInt();
		
		float arr[]=new float[n];
		
		while(i<n)
		{
		
		 System.out.println("Enter Language");
		 String str=sc.next();
		 System.out.println("working Time");
		 arr[i]=sc.nextInt();
		
	   sum=sum+arr[i];
	    i++;
		}
	     float average=sum/n;
	     System.out.println("Average of number is:"+average);
		}


}
