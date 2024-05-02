package liftsystemapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LiftManagementSystem {
	static Scanner scan = new Scanner(System.in);
	static List<Lift> arrayLift= new ArrayList<>();
	public static void main(String[] args) 
	{
		System.out.println("Enter the Lift details : ");
		for(int i=0;i<5;i++)
		{
			System.out.println("Enter Lift name : ");
			String liftName=scan.next();
			System.out.println("Enter the lift condition : ");
			int liftCondition=scan.nextInt();
			System.out.println("Enter the lift capacity : ");
			int liftCapacity=scan.nextInt();
			System.out.println("Enter the lift position : ");
			int liftPosition=scan.nextInt();
			Lift lift= new Lift(liftName,liftCapacity,liftCondition,liftPosition);
			arrayLift.add(lift);
		}
		while(true)
		{
			System.out.println("Enter the choice \n1) Use lift \n2) Display Lift Positions \n3) Exit");
			String choice=scan.next();
			switch(choice)
			{
			case "1": uselift();
			break;
			case "2": showLiftDetails();
			break;
			case "3": break;
			default:System.out.println("Enter the correct option ...!!!");
			}
			if(choice.equals("3")) 
				{
				System.out.println("~~~~ Thank you ~~~~");
				  break;
				}
		}	
	}
	public static void showLiftDetails() {
		for(Lift l:arrayLift)
		{
			System.out.println("Lift "+l.getName()+" Lift capacity "+l.getCapacity()+" Lift position : "+l.getPosition()+"\n");
		}
		
	}
	public static void uselift() {
		System.out.println("Enter the current position(0-10) : ");
		int startPosition=scan.nextInt();
		System.out.println("Enter the destination (0-10): ");
		int endPosition=scan.nextInt();
		System.out.println("Enter the number of people : ");
		int numberOfPeople=scan.nextInt();
		int position=getMinPosition(startPosition, endPosition);
		for(int i=0;i<5;i++)
		{
			//|| arrayLift.get(i).getPosition()==0
			if(numberOfPeople<=arrayLift.get(i).capacity)
			{
				if((arrayLift.get(i).getPosition()==startPosition  || i==position)  )
				{
					if((arrayLift.get(i).getName().equals("L1") || arrayLift.get(i).getName().equals("L2")) && ((endPosition>=0 && endPosition<=5) && startPosition>=0 && startPosition<=5))
					{
						arrayLift.get(i).setPosition(endPosition);
						System.out.println("Lift "+arrayLift.get(i).getName()+" is assigned \n");
						break;
					}
					else if((arrayLift.get(i).getName().equals("L3") || arrayLift.get(i).getName().equals("L4")) && (((endPosition>=6 && endPosition<=10) || endPosition==0) && ((startPosition>=6 && startPosition<=10)|| startPosition==0)))
					{
						arrayLift.get(i).setPosition(endPosition);
						System.out.println("Lift "+arrayLift.get(i).getName()+" is assigned \n");
						break;
						
					}
					else// if(arrayLift.get(i).getName().equals("L5"))
					{
						arrayLift.get(i).setPosition(endPosition);
						System.out.println("Lift "+arrayLift.get(i).getName()+" is assigned \n");
						break;
					}
				}
			}
			else
			{
				System.out.println("\nPlease Reduce "+Math.abs((arrayLift.get(i).getCapacity()-numberOfPeople))+" to Proceed\n");
			}
			
		}
//		for(Lift l:arrayLift)
//		{
//			System.out.println("Lift Name"+l.getName()+" Lift Condition : "+l.getCondition()+" Lift capacity "+l.getCapacity()+" Lift position : "+l.getPosition());
//		}
	
		
	}
	public static int getMinPosition(int start, int end) {
		int min=Integer.MAX_VALUE;
		int liftNo=-1;
		int temp=start-end;
		int max=Integer.MIN_VALUE;
		for(int i=0;i<5;i++)
		{
			if(arrayLift.get(i).getCondition()==1)
			{
				if(min>Math.abs(arrayLift.get(i).getPosition()-start) )
					{
						min=Math.abs(arrayLift.get(i).getPosition()-start);
						liftNo=i;
						
						if(temp>0)
						{	
							max=Math.max(arrayLift.get(i).getPosition(),max);
							liftNo=i;
						}
						else
						{
							max=Math.min(arrayLift.get(i).getPosition(),max);
							liftNo=i;
						}
						
					}
			}
			// if the current lift is not working
			else 
			{
				continue;
			}
		}
		System.out.println("\nLift number is "+liftNo+1+"\n");
		return liftNo;
	}

}
