import java.util.ArrayList;
import java.util.InputMismatchException; 
import java.util.Scanner; 

public class system_run {
	private ArrayList <Customer> customer_IN=new ArrayList<Customer>(); 
	private Scanner input=new Scanner(System.in);
	private Admin admin=new Admin("mohamed", "awseem"); 
	
	//===========================================================================
	private int validate_choice()throws InputMismatchException
	{
		int choice=input.nextInt(); 
		while(choice!= 1 && choice !=2 && choice!=0)
		{
			System.out.println("Wrong choice plz try again" );
			choice=input.nextInt();
		}
		return choice; 
	}
	
	//===========================================================================
	private char validate_ch() throws InputMismatchException
	{
		char ch=input.next().charAt(0);
		while(ch!= 'Y' && ch!='N')
		{
			System.out.println("Wrong choice plz try again " );
			ch=input.next().charAt(0);
		}
		return ch; 
	}
	//=============================================================================
	public system_run()
	{
		try {
		System.out.println("\t\tWelcome to Supermarket Simulator Program\n\n\n\n");
		int choice; 
		while(true)
		{
			System.out.println("Press 1 to Enter as admin, 2 to Enter as customer, and 0 to end the program:");
			choice=this.validate_choice(); 
			if(choice==0)break; 
	   else if(choice==1)
	   {
		   boolean flag=true ;
		   char ch; 
		   while(flag)
		   {
		   admin.menue();
		   int in=admin.choice(); 
		   admin.make(in, customer_IN);
		   System.out.println("Do you want to do another operation? ");
		   ch=this.validate_ch(); 
		   if(ch=='N')flag=false ; 
		   }
		   
	   }
	   else 
	   {
		   int in; 
		   System.out.println("Plz enter number of customers:" );
		   in=input.nextInt();
		   for(int i=0; i<in; i++)
		   {
			   Customer c=new Customer(); 
			   c.BuyItems();
			   c.print_receipt();
			   customer_IN.add(c);  c=null; 
			   
		   }
	   }
			
		}
		
	
	}
		catch(InputMismatchException e)
		{
			System.out.println("Wrong input ");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

}
}