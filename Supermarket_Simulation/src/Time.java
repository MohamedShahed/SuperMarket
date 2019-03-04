
public class Time {
	private int hours;
	private int minutes;
	
	
	public Time() {}
	public Time(int h, int m)
	{
		this.hours=h;
		while(m>=60)
		{
			this.hours+=1;
			m-=60;
			
		}
		this.minutes=m;
		
	}
	public int getHours()
	{
		return hours;
	}
	public void setHours(int hours)
	{
		this.hours = hours;
	}
	public int getMinutes()
	{
		return minutes;
	}
	public void setMinutes(int m) 
	{
		while(m>=60)
		{
			this.hours+=1;
			m-=60;
			
		}
		this.minutes=m;
	}
	
	public void reset()
	{
		while(minutes>=60)
		{
			this.hours+=1;
			minutes-=60;
			
		}
		
	}
	public Time Pluse_Operator(Time t)
	{
		Time re=new Time(); 
		re.setHours(this.hours+t.getHours());
		re.setMinutes(this.minutes+ t.getMinutes());
		return re; 
	}
	public void Print_Time()
	{
		System.out.println(this.hours + " : " + this.minutes);
	}
	
	public void print()
	{
		System.out.println(this.hours + ":" +this.minutes );
	}
	
	boolean less_operator(Time t)
	{
		if(this.hours<t.getHours())return true ;
		else if(this.hours==t.getHours())
			return (this.minutes<t.getMinutes()?true: false);
		return false ;
	}

}
