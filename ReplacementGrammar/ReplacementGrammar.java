public class ReplacementGrammar
{
	private class Node()
	{
		private String rule;
		private String replace;
		private Node next;
	}
	public static void main(String[] args)
	{
		ArrayList<String> ruleList = new ArrayList<String>();
		while (!StdIn.isEmpty())
		{
			
			String line = StdIn.readLine();
			ruleList.add(line);
			if (line.equals(""))
				break;
		}
		StdIn.readLine();
		StdIn.readLine();
		String text = StdIn.readLine();
		for (String rule: ruleList)
		{
			int loc = rule.indexOf("/");
			String.replaceAll("Milan(?! Vasic)", "Milan Vasic")
		}
	}
}