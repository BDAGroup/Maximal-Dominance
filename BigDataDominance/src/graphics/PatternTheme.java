package graphics;


import com.jtattoo.plaf.AbstractTheme;


public class PatternTheme extends AbstractTheme {

	
	public String name ;
	
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	
	@Override
	public void setUpColor(){
		
		backgroundPattern = false;
		logoString = (name);	
	}
}
