

import controller.ListDetailsHelper;
import controller.UserHelper;
import controller.LocalDateAttributeConverter;
import model.ListDetails;
import model.ListItem;
import model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserTester {

	public static void main(String[] args)	{
		User tyler = new User("Tyler");
		
		ListDetailsHelper ldh = new ListDetailsHelper();
		ListItem Bengals = new ListItem("Bengals", "0");
		ListItem Steelers = new ListItem("Steelers", "7");
		
		
		List<ListItem> tylersTeams = new ArrayList<ListItem>();
		tylersTeams.add(Bengals);
		tylersTeams.add(Steelers);
		
		
		ListDetails tylersList = new ListDetails("Tyler's Guesses for  NFL Super Bowls", LocalDate.now(), tyler);
		tylersList.setListOfItems(tylersTeams);
		
		ldh.insertNewListDetails(tylersList);
		
		List<ListDetails> allLists = ldh.getLists();
		for(ListDetails a: allLists) {
			System.out.println(a.toString());
		}
		
	}
}
