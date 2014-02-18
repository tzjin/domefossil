import java.util.StringTokenizer;

public class NDrome
{
	private String[] tokens;
	private int N;

	public NDrome(String input, int N)
	{
		this.N = N;
		tokens = new String[input.length() / N];
		int stringPos = 0;

		for(int i = 0; i < input.length() / N; i++)
		{
			tokens[i] = input.substring(stringPos, stringPos + N);
			stringPos += N;
		}
	}

	public int isNDrome()
	{
		int front = 0;
		int back = tokens.length - 1;

		while(front < back)
		{
			if(!tokens[front].equals(tokens[back]))
				return 0;

			front++;
			back--;
		}

		return 1;
	}

	public static void main(String[] args)
	{
		while(!StdIn.isEmpty())
		{
			String input = StdIn.readString();
			//System.out.println(input);
			/*String[] stuff = input.split("|");
			for(String s: stuff)
				System.out.println(s);
			System.out.println(stuff[0]);
			System.out.println(stuff[1]);

			*/

			StringTokenizer st = new StringTokenizer(input, "|");
			String[] stuff = new String[2];
			stuff[0] = st.nextToken();
			stuff[1] = st.nextToken();

			NDrome ndrome = new NDrome(stuff[0], Integer.parseInt(stuff[1]));

			StdOut.println(input + "|" + ndrome.isNDrome());
		}
	}
}