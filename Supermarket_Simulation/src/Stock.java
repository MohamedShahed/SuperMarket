import java.util.ArrayList;
import java.util.Scanner;

public class Stock {
	
	private Scanner  input=new Scanner(System.in); 
	private ArrayList<Item> Item_List=new ArrayList<Item>(); 
	private int Item_Numbers=0;
	private static Stock obj=null;
	//===============================================================================================
	
	private Stock() {}
	//singleton design pattern 
	public static Stock creat_obj()
	{
		if(obj==null)obj=new Stock(); 
		return obj;
	}
	
	//===============================================================================================
	
	public void Insert_Item()
	{
	    Item item=new Item(); 
		System.out.println("enter the Item name  :");item.setName(input.next());
		System.out.println("enter the Item type  : ");item.setType(input.next());
		System.out.println("enter available units:");item.setAvailAmount(input.nextInt());
		System.out.println("enter the Item price : ");item.setPrice(input.nextDouble());
		
		int indx=Item_name_searching(item.getName());
		if(indx==-1)
		{
			Item_List.add(Item_Numbers++, item);
			
		}
		else 
			Item_List.get(indx).setAvailAmount(Item_List.get(indx).getAvailAmount()+1);
		item=null;
		
	}
	
	//===============================================================================================
	
	public void menue()
	{
		
		System.out.print("Item\t|\t\t\t");
		System.out.print("name\t|\t\t\t");
		System.out.print("Type\t|\t\t\t");
		System.out.print("units\t|\t\t\t");
		System.out.print("price\n");
		System.out.println("=====================================================================");
		for(int i=0; i<Item_List.size(); i++)
		{
			if(Item_List.get(i).getAvailAmount()==0)continue;
			Item_List.get(i).Item_Info();
			System.out.println();
		}
	}
	//===============================================================================================
	
	public int  Item_searching(int id)
	{
		for(int i=0; i<Item_List.size(); i++)
		{
			if(Item_List.get(i).getID()==id/* && Item_List.get(i).getAvailAmount()>0*/)return i;
		}
		return -1;
		
	}
	//==============================================================================================
	public int Item_name_searching(String name)
	{
		for(int i=0; i<Item_List.size(); i++)
		{
			if(Item_List.get(i).getName().equals(name))
				return i;
		}
		return -1;
	}
	//===============================================================================================
	
	public Item getItem(int i)
	{
		return Item_List.get(i);
	}
	//===============================================================================================
	
	public void updat()
	{
		int indx;
		System.out.println("the item that we have are : " );
		for(int i=0; i<Item_List.size(); i++)
			System.out.println(i+1 + ") " + Item_List.get(i).getID());
		while(true)
		{
		System.out.println("enter Item ID : ");
		indx=this.Item_searching(input.nextInt());
		if(indx==-1)
		{
			System.out.println("this id not found try again ");
		}
		
		else 
		{
			System.out.println("update the Item" );
			System.out.println("enter the Item name  :");Item_List.get(indx).setName(input.next());
			System.out.println("enter the Item type  : ");Item_List.get(indx).setType(input.next());
			System.out.println("enter available units:");Item_List.get(indx).setAvailAmount(input.nextInt());
			System.out.println("enter the Item price : ");Item_List.get(indx).setPrice(input.nextDouble());
			System.out.println("Done" );
			break;
		}
		
		}
		
		
	}
	//===============================================================================================

}
