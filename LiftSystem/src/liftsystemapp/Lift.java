package liftsystemapp;

class Lift
{
	String name;
	int capacity;
	int condition;
	int position;
	
	
	public Lift(String name, int capacity, int condition, int position) {
		super();
		this.name = name;
		this.capacity = capacity;
		this.condition = condition;
		this.position = position;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getCondition() {
		return condition;
	}
	public void setCondition(int condition) {
		this.condition = condition;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
}
