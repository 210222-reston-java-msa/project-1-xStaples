
import com.revature.services.UserServices;

public class Driver {
	public static void main(String[] args) {
		UserServices us = new UserServices();
		
		System.out.println(us.confirmLogin("xStaples", "admin1"));
		
		
	}
}
