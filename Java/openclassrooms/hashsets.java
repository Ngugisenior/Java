import java.util.*;

public class IngredientsSet {

	public static void main(String[] args) {
		
		Set<String> ingredients = new HashSet<>();
		ingredients.add("sugar");
		ingredients.add("chocolate");
		ingredients.add("butter");
		ingredients.add("vanilla");
        ingredients.remove("vanilla");
        ingredients.add("lavender");
		
        //TODO add another ingredient to the set
        
        //TODO now remove vanilla from the set
        
        //Print the resuting set
	    System.out.println("Here is our ingredients list");
        for(String ingredient: ingredients){
            System.out.println(ingredient);
        }
	}

}
