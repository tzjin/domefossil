import java.text.*;
public class ClockAngle
{
	public static void main(String[] args)
	{
		int N = Integer.parseInt(StdIn.readLine());
		for (int i = 0; i < N; i++)
		{
			DecimalFormat df = new DecimalFormat("#.##");
        	
			String times = StdIn.readLine();
			//System.out.println(times);
			int hour = Integer.parseInt(times.substring(0,2));
			int minutes = Integer.parseInt(times.substring(3,5));
			int seconds = Integer.parseInt(times.substring(6));
			double hourAng = 360.0 / (12.0/hour);
			double minuteAng = 360.0 / (60.0/minutes);
			double secAng = 360.0 / (60.0/seconds);

			double ang = hourAng - minuteAng;
			if (ang < 0)
				ang *= -1;
			if (ang > 180)
				ang = 360.0 - ang;

			StdOut.printf("%.2f", ang);
			StdOut.print(", ");

			ang = hourAng - secAng;
			if (ang < 0)
				ang *= -1;
			if (ang > 180)
				ang = 360.0 - ang;

			StdOut.printf("%.2f", ang);
			StdOut.print(", ");

			ang = minuteAng - secAng;
			if (ang < 0)
				ang *= -1;
			if (ang > 180)
				ang = 360.0 - ang;
			StdOut.printf("%.2f", ang);
			System.out.println();
		}

	}
}