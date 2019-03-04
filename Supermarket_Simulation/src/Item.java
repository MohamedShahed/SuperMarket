import java.util.ArrayList;
import java.util.Collections;

public class Item {
	private String name ; 
	private int ID;  
	private String type; 
	private int availAmount; 
	private double price ;
	private final static int Max_Items=2000;
	private static ArrayList<Integer>list=new ArrayList<Integer>(Max_Items); 
	private static int counter=0; 

	//======================================================================================================
	
	public Item()
	{	
		if(counter==0)
		{

			for(int i=0; i<Max_Items; i++)Item.list.add(i+100);
			Collections.shuffle(list);
		}
		this.ID=list.get(counter++);
		
	}
	//======================================================================================================

	public String getName() 
	{
		return name;
	}
	//======================================================================================================

	public void setName(String name)
	{
		this.name = name;
	}
	//======================================================================================================

	public int getID() 
	{
		return ID;
	}
	//======================================================================================================

	public String getType()
	{
		return type;
	}
	//======================================================================================================

	public void setType(String type)
	{
		this.type = type;
	}
	//======================================================================================================

	public int getAvailAmount() 
	{
		return availAmount;
	}
	//======================================================================================================

	public void setAvailAmount(int availAmount) 
	{
		this.availAmount = availAmount;
	}
	//======================================================================================================

	public double getPrice()
	{
		return price;
	}
	//======================================================================================================

	public void setPrice(double price)
	{
		this.price = price;
	} 
	//======================================================================================================

	public void Item_Info()
	{
		System.out.print(this.ID  + "\t|\t\t\t");
		System.out.print(this.name+"\t|\t\t\t");
		System.out.print(this.type+"\t|\t\t\t");
		System.out.print(this.availAmount +"\t|\t\t\t");
		System.out.println(this.price);
	}
	//======================================================================================================

	

}
