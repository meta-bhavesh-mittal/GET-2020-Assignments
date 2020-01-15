import java.util.Scanner;


public class JobScheduler {

	// method to calculate completion time
	public static int [] CompletionTime(int [][] process , int numOfProcess)
	{
		
		int[] completionTime = new int[numOfProcess];
		for(int i=0 ; i<numOfProcess; i++)
		{
			if(i == 0)
			{
				completionTime[i] = process[i][0] + process[i][1];

			}
			else
			{
				if(process[i][0] > completionTime[i-1])
				{
					completionTime[i] = process[i][0] + process[i][1];
				}
				else
				{
					completionTime[i] = completionTime[i-1] + process[i][1];
				}
			}



		}
		return completionTime;
	}

	//method to calculate the turn around time
	
	public static int[] TurnAroundTime(int[] completionTime , int numOfProcess , int[][] process)
	{
		int[] turnAroundTime = new int[numOfProcess];
		for(int i=0 ; i<numOfProcess; i++)
		{
			turnAroundTime[i] = completionTime[i] - process[i][0];
			
		}
		return turnAroundTime;
	}
	
	
	//method to calculate the waiting time
	
	public static int[] WaitingTime(int[] turnAroundTime , int numOfProcess , int[][] process)
	{
		int [] waitingTime = new int[numOfProcess];
	
		for(int i=0 ; i<numOfProcess; i++)
		{
			waitingTime[i] = turnAroundTime[i] - process[i][1];
			
		}		
		return waitingTime;
	}
	
	
	public static void main(String[] args)
	{

		Scanner input = new Scanner(System.in);
		try
		{
			System.out.println("Enter the number of process you want to enter");
			int numOfProcess = input.nextInt();	// scan the number of processes from user 
			int[][] process = new int[100][2];	// array to store the process's arrival and burst time
			int[] completionTime = new int[numOfProcess];	// array to store the completion time
			int waitingTime[] = new int[numOfProcess];	//array to store the waiting time
			int turnAroundTime[] = new int[numOfProcess];	//array to store the turnaround time
			float totalWaitingTime = 0;
			int maxWaitingTime = 0;


			for(int i=0;i < numOfProcess;i++)
			{
				System.out.print("Enter the process arrival time : ");
				process[i][0] = input.nextInt();
				System.out.print("Enter the process burst time : ");
				process[i][1] = input.nextInt();
				System.out.println();
			}

			
			// sort the process array according to arrival time
			for(int k = 0;k <= (numOfProcess-1); k++)
			{
				for(int j =0;j < (numOfProcess-1); j++)
				{
					if(process[j][0] > process[j+1][0])
					{
						int temp1,temp2;
						temp1 = process[j][0];
						temp2 = process[j][1];

						process[j][0] = process[j+1][0];
						process[j][1] = process[j+1][1];

						process[j+1][0] = temp1;
						process[j+1][1] = temp2;


					}

				}
			}

			completionTime = CompletionTime(process , numOfProcess);
			turnAroundTime  = TurnAroundTime(completionTime , numOfProcess , process);
			waitingTime  = WaitingTime(turnAroundTime , numOfProcess , process);
			
			//calculate the total waiting time
			
			for(int i = 0; i < numOfProcess; i++)
			{
				totalWaitingTime+= waitingTime[i];
			}

			// calculate the maximum waiting time
			for(int i = 0; i < numOfProcess; i++)
			{
				if(waitingTime[i] > maxWaitingTime)
				{
					maxWaitingTime = waitingTime[i];
				}
			}

			System.out.println("\nArrival	  Burst	  Complete  TurnAround  Waiting");
			for(int i = 0; i<numOfProcess; i++ )
			{
				System.out.println(  process[i][0] + "\t  " + process[i][1] + "\t  " + completionTime[i] + "\t    " + turnAroundTime[i] + "\t\t" + waitingTime[i]);
			}


			System.out.println("\nThe Average WaitingTime of Each Process is :  "+ (totalWaitingTime/numOfProcess));
			System.out.println("\nThe Maximum WaitingTime of Process is :  "+ maxWaitingTime);
			
		}

		catch(Exception ex)
		{
			System.out.println("\nEnter the correct information");
		}
	}


}


