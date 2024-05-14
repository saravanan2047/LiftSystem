package liftsystemapp.liftpanel;

import java.util.List;
import java.util.Scanner;
import liftsystemapp.LiftMain;
import liftsystemapp.model.Lift;

public class LiftView 
{
	static Scanner scan= new Scanner(System.in);
	private static LiftModel liftmodel;
	public LiftView()
	{
		this.liftmodel= new LiftModel(this);
	}
	public void onCreation() 
	{
		System.out.println("~~~~ Welcome to Lift Management System ~~~~\n\n---------- " + LiftMain.getInstance().getAppName() +" ---------- \n\n\t    version: "+ LiftMain.getInstance().getVersion()+"\n\n");
					createLift();
	 }
	public static void createLift() {
		System.out.println("--> Enter the Lift details\n ");
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
			LiftModel.addLift(lift);
		}
		init();
	}
	public static void init() 
	{	
		while(true)
		{
			System.out.println("Enter the choice \n1) Use lift \n2) Display Lift Positions \n3) Lift Maintenance \n4) Exit");
			String choice=scan.next();
			switch(choice)
			{
				case "1": uselift();
				break;
				case "2": showLiftDetails();
				break;
				case "3": liftMaintenance();
				break;
				case "4": break;
				default:System.out.println("Enter the correct option ...!!!");
			}
				if(choice.equals("4")) 
					{
						System.out.println("~~~~ Thank you ~~~~");
						 break;
					}
				}	
			}

			public static void liftMaintenance() {
				System.out.println("Select option \n1) Repair lift \n2) Keep under maintenance\n");
				String choice = scan.next();
				System.out.println("Enter the lift name : ");
				String liftName = scan.next();
				liftmodel.maintain(liftName, choice);
				System.out.println("Lift " + liftName + " is  maintined Successfully\n");

			}
			public static void showLiftDetails() 
			{
				List<Lift> arrayLift=liftmodel.getLift();
				for(Lift l:arrayLift)
				{
					System.out.println("Lift "+l.getName()+" Condition : "+l.getCondition()+" Lift capacity "+l.getCapacity()+" Lift position : "+l.getPosition()+"\n");
				}
				
			}
			public static void uselift() {
				System.out.println("Enter the current position(0-10) : ");
				int startPosition=scan.nextInt();
				System.out.println("Enter the destination (0-10): ");
				int endPosition=scan.nextInt();
				System.out.println("Enter the number of people : ");
				int numberOfPeople=scan.nextInt();
				
				liftmodel.useLift(startPosition, endPosition,numberOfPeople);
			}
		}
