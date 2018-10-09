import java.util.ArrayList;

/**
 * Show the use of recursion to solve a problem.
 * October 5, 2018
 * @author Joseph Hentges
 */
public class NewMain {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		ArrayList<Integer> out = recursiveMethod(500);
		System.out.println(out.toString());
	}
	
	/**
	 * Find the lowest multiples of a given number
	 * Example input : 100 - Output : [2,2,5,5,1]
	 * @param input : int - An integer representing the value to find its multiples
	 * @return output : ArrayList - An array list of integers
	 */
	public static ArrayList<Integer> recursiveMethod(int input)
	{

		ArrayList<Integer> output = new ArrayList<Integer>();
		if (input < 1)
		{
			return output;
		}
		if (input == 1)
		{
			output.add(1);
			return output;
		}
		else
		{
			int x = 2;
			while (input % x != 0)
			{
				x++;
			}
			output.add(x);
			output.addAll(recursiveMethod(input/x));
		}
		return output;
	}
}