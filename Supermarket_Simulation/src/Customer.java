import java.util.ArrayList;
import java.util.Scanner; 
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Calendar;
import java.util.Collections;

public class Customer extends Person {
	private int ID;
	private ArrayList<ShoppingItem> ShoppingList;
	private Time ArrivalTime; 
	

	private Time ShoppingDuration; 
	private Time CheckOutTime; 
	private final static int max_customer=2000; 
	private static ArrayList<Integer> customer_id=new ArrayList<>(max_customer); 
	private static int index=0;
	private Date ToDay; 
	private Calendar calendar;
	private Random Rnd;
	private Stock stock=Stock.creat_obj();
	private double receipt=0;
	private Scanner input=new Scanner(System.in);
	
	

	public Customer()
	{
		ToDay=new Date();
		ShoppingList=new ArrayList<ShoppingItem> ();
		ArrivalTime=new Time();
		ShoppingDuration=new Time();
		CheckOutTime=new Time(); 
		
		
		
		calendar = GregorianCalendar.getInstance();
		calendar.setTime(ToDay);
		this.ArrivalTime.setHours(calendar.get(Calendar.HOUR));
		this.ArrivalTime.setMinutes(calendar.get(Calendar.MINUTE));
		
		if(index==0)
		{

			for(int i=0; i<max_customer; i++)Customer.customer_id.add(i+100);
			Collections.shuffle(customer_id);
		}
		this.ID=customer_id.get(index++);
		
		
	}
	//===============================================================================================
	public Time getCheckOutTime()
	{
		return CheckOutTime;
	}
	//===============================================================================================
	public void Check_Out()
	{
		Rnd=new Random(); 
		int h=Rnd.nextInt()%4;
		int m=Rnd.nextInt()%60;
	                          	//set Duration  time
		this.ShoppingDuration.setHours(h>=0?h:h*-1);  
		this.ShoppingDuration.setMinutes(m>=0?m: m*-1);
		                        //set Check_Out time
		this.CheckOutTime=this.ArrivalTime.Pluse_Operator(this.ShoppingDuration);
		
	}
	
	//===============================================================================================
	public void BuyItems()
	{
		int choice;  //using item_id
		int amount; 
		
		ShoppingItem sh_Item=new ShoppingItem(); //get item and amount 
		stock.menue();
		while(true)
		{
			System.out.println("plz enter the id for the item that u need " );
			choice=input.nextInt();
			int index=stock.Item_searching(choice);
			if(index!=-1)
			{	
				while(true)
				{
					System.out.println("enter the amount : ");
					amount=input.nextInt();
					if(amount>stock.getItem(index).getAvailAmount())
						{
						System.out.println("the amount not enough try again : " );continue;
						}
					else 
					{
						System.out.println("Done" );
						stock.getItem(index).setAvailAmount(stock.getItem(index).getAvailAmount()-amount);//update available amount 
						sh_Item.setAmount(amount); 
						sh_Item.setItem(choice);
						ShoppingList.add(sh_Item);
						receipt+=(amount*stock.getItem((stock.Item_searching(choice))).getPrice());
						break;
						
					}
					
				}
				
				break;
			}
			else 
			{
				System.out.println("this id not fount try again  " );
			}
		}
		sh_Item=null;
		
	}
	//======================================================================================================

	public double getReceipt()
	{
		return receipt;
	}
	//======================================================================================================
	public void print_receipt()
	{
		System.out.println(this.receipt + "  LE");
	}
	//======================================================================================================

	public int GetID()
	
	{
		return this.ID;
	}
	//======================================================================================================

	public Time CheckOutTime()
	{
		return this.CheckOutTime;
	}
	
	//======================================================================================================
	public static class ShoppingItem{
		private int  item_id;
		private int Amount;
		//=======================================
		
		
		
		public void setItem(int  i)
		{
			this.item_id=i;
			
		}
		//=======================================
		public int getItem_id()
		{
			return this.item_id;
		}
		//=======================================
		public void setAmount(int amount)
		{
			this.Amount=amount;
		}
		//=======================================
		public int getAmount()
		{
			return this.Amount;
		}
	}
	
	//======================================================================================================

}
