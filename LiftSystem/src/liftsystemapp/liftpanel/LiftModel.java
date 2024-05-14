package liftsystemapp.liftpanel;

import java.util.List;

import liftsystemapp.liftDb.LiftDatabase;
import liftsystemapp.model.Lift;

public class LiftModel 
{
	private static LiftView liftview;
	public LiftModel(LiftView liftView)
	{
		this.liftview=liftView;
	}
	
	public static void addLift(Lift lift)
	{
		LiftDatabase.createInstance().addLift(lift);
	}

	public void maintain(String liftName, String choice) {
		if (choice.equals("1"))
			LiftDatabase.createInstance().maintainLift(liftName, 1);
		else
			LiftDatabase.createInstance().maintainLift(liftName, -1);
	}

	public List<Lift> getLift() 
	{
		return LiftDatabase.createInstance().getLift();
	}
	
	public void useLift(int startPosition, int endPosition, int numberOfPeople) 
	{
		int position=getMinPosition(startPosition, endPosition);
		List<Lift> arrayLift=LiftDatabase.createInstance().getLift();
		for(int i=0;i<5;i++)
		{
			if(numberOfPeople<=arrayLift.get(i).capacity)
			{
				if(((arrayLift.get(i).getPosition()==startPosition && arrayLift.get(i).getCondition()!=-1) || (i==position && arrayLift.get(position).getCondition()!=-1)))
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
					else if(arrayLift.get(i).getName().equals("L5") && ((endPosition>=0 && endPosition<=10) && startPosition>=0 && startPosition<=10))
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
				break;
			}	
		}
	}

	public static int getMinPosition(int start, int end) {
		List<Lift> arrayLift = LiftDatabase.createInstance().getLift();
		int min = Integer.MAX_VALUE;
		int liftNo = -1;
		int temp = start - end;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < 5; i++) {
			if (arrayLift.get(i).getCondition() != -1) {
				if (min > Math.abs(arrayLift.get(i).getPosition() - start)) {
					min = Math.abs(arrayLift.get(i).getPosition() - start);
					liftNo = i;

					if (temp > 0) {
						max = Math.max(arrayLift.get(i).getPosition(), max);
						liftNo = i;
					} else {
						max = Math.min(arrayLift.get(i).getPosition(), max);
						liftNo = i;
					}

				}
			}
			// if the current lift is not working
			else {
				continue;
			}
		}
		return liftNo;
	}
}
