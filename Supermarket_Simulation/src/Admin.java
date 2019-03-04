import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends Person {
	
	private Stock stock_obj=Stock.creat_obj(); //DB for items 
	private Scanner input; 
	private double total_revenue=0;
	
	public Admin(String name , String add)
	{
		super(name, add);
	}
	//==========================================================
	public void ReportAvailableItems()
	{
		stock_obj.menue(); //need red colore
	}
	//==========================================================
	
	public void AddNewItem()
	{
		stock_obj.Insert_Item();
	}
	//==========================================================
	
	public void UpdateExistingItem()
	{
		stock_obj.updat();
	}
	//==========================================================
	public double get_total_revenue(ArrayList<Customer> AllCustomer)
	{
		for(int i=0 ; i<AllCustomer.size(); i++)
		{
			total_revenue+=AllCustomer.get(i).getReceipt();
		}
		return total_revenue; 
	}
	//==========================================================
	
	public void ReportTotalRevenue(ArrayList<Customer> AllCustomer)
	{
		for(int i=0; i<AllCustomer.size(); i++)AllCustomer.get(i).Check_Out();
		this.sort_customer(AllCustomer);
		System.out.println("the total revenue : " + this.get_total_revenue(AllCustomer));
		System.out.println("Order of the customers are:");
		for(int i=0 ; i<AllCustomer.size(); i++)
			{
			System.out.print(AllCustomer.get(i).getName() + ", checkout at : " );
			AllCustomer.get(i).getCheckOutTime().Print_Time();
			}
		AllCustomer.clear();
		
	}
	//=========================================================
	private void sort_customer(ArrayList<Customer> AllCustomer)
	{
		Customer Key=new Customer();
		for(int i=1, j; i<AllCustomer.size(); i++)
		{
			Key=AllCustomer.get(i);
			j=i-1; 
			while(j>=0 && !AllCustomer.get(j).getCheckOutTime().less_operator(Key.getCheckOutTime()))
			{
				AllCustomer.set(j+1, AllCustomer.get(j));
				j--; 
			}
			AllCustomer.set(j+1, Key);
		}

	}
	//==========================================================
	public void DisplayTotalCustomers(ArrayList<Customer> arr)
	{
		System.out.println("The currently available customers are :" + arr.size());
	}
	//==========================================================
	public void DisplayMaxReceipt(ArrayList<Customer> arr)
	{
		double max=0; 
		for(int i=0; i<arr.size(); i++)
		{
			max=(max>arr.get(i).getReceipt()?max:arr.get(i).getReceipt());
		}
		
		System.out.println("the max receipt is : " + max);
		
	}
	//==========================================================
	public void menue()
	{
		System.out.println("1) ReportAvailableItems\n"
						  +"2) AddNewItem\n"
						  +"3) UpdateExistingItem\n"
						  +"4) ReportTotalRevenue\n"
						  +"5) DisplayTotalCustomers\n"
						  +"6) DisplayMaxReceipt\n\n");
	}
	public int choice()
	{
		input=new Scanner(System.in); 
		int c; 
		while(true)
		{
			c=input.nextInt(); 
			if(c!=1 && c!=2 && c!=3 && c!=4 && c!=5 && c!=6)System.out.println("wrong... try again " );	
			else break;
			
		}
		
		 return c; 
	}
	public void make(int n, ArrayList<Customer> AllCustomer)
	{
		if     (n==1)this.ReportAvailableItems();
		else if(n==2)this.AddNewItem();
		else if(n==3)this.UpdateExistingItem();
		else if(n==4)this.ReportTotalRevenue(AllCustomer);
		else if(n==5)this.DisplayTotalCustomers(AllCustomer);
		else this.DisplayMaxReceipt(AllCustomer);
	}
}
