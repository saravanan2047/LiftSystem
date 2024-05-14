package liftsystemapp;

import liftsystemapp.liftpanel.LiftView;

public class LiftMain {

	private static LiftMain liftmain;
	private String appName="Lift Management System";
	private String version="0.0.1";
	
	public LiftMain()
	{}
	public static LiftMain getInstance()
	{
		if(liftmain==null)
		{
			liftmain=new LiftMain();
		}
		return liftmain;
	}
	
	public void create()
	{
		LiftView liftview= new LiftView();
		liftview.onCreation();
	}
	
	public String getAppName()
	{
		return liftmain.appName;
	}
	
	public String getVersion()
	{
		return liftmain.version;
	}
	
	public static void main(String[] args) {
		LiftMain.getInstance().create();
	}
}
