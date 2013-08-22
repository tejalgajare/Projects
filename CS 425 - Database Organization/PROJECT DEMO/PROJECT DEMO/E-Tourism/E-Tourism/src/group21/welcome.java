package group21;

public class welcome {

	/**
	 * @param args
	 */
	
		static String username;
		static int attr_id=0;
		static int itr_id=0;
		static int admin_update_choice=0;
		public welcome()
		{
		
		}
		
			
	public static void setName(String newuser)
	{
		
		username = newuser;
	}
	
	
		public static String getUsername()
	{
		return username;
		
	}
		public static void setAttr(int newuser)
		{
			
			attr_id = newuser;
		}
		
		
			public static int getAttr()
		{
			
				return attr_id;
			
		}
			public static void setitr(int newuser)
			{
				
				itr_id = newuser;
			}
			
			
				public static int getitr()
			{
				return itr_id;
				
			}
				public static void setAdminChoice(int newuser)
				{
					
					admin_update_choice = newuser;
				}
				
				
					public static int getAdminChoice()
				{
					return admin_update_choice;
					
				}
public static void main(String[] args)
{
	group21.welcome w=new group21.welcome();
	
}
}