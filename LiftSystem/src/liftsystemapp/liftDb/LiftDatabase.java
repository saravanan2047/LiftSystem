package liftsystemapp.liftDb;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import liftsystemapp.model.Lift;

public class LiftDatabase 
{	
	private static LiftDatabase liftDb;
	static Scanner scan = new Scanner(System.in);
	static List<Lift> arrayLift= new ArrayList<>();
	public static LiftDatabase createInstance()
	{
		if(liftDb==null)
		{
			liftDb=new LiftDatabase();
		}
		return liftDb;
	}
	public  void addLift(Lift lift)
	{
		arrayLift.add(lift);
	}

	public void maintainLift(String liftName, int condition) {
		for (int i = 0; i < arrayLift.size(); i++) {
			if (arrayLift.get(i).getName().equals(liftName)) {
				arrayLift.get(i).setCondition(condition);
				break;
			}
		}
	}
	public List<Lift> getLift() {
		return arrayLift;
	}
}
