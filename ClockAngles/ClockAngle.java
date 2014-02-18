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
			double addSecSec, addSecHour, addSecMin, addMinMin, addMinHour, addHourHour;
			if (seconds != 0)
			{
				addSecMin = (360.0/60) / (60.0/seconds);
				addSecHour = (360.0/12/60) / (60.0/seconds);
				addSecSec = 360.0 / (60.0/seconds);
			}
			else
			{
				addSecMin = 0;
				addSecHour = 0;
				addSecSec = 0;
			}
			if (minutes != 0)
			{
				addMinMin = 360.0 / (60.0/minutes);
				addMinHour = (360.0 / 12) / (60.0/minutes);

			}
			else
			{
				addMinMin = 0;
				addMinHour = 0;
			}
			if (hour != 0)
			{
				addHourHour = 360.0 / (12.0/hour);
			}
			else
			{
				addHourHour = 0;
			}
			
			double secAng = addSecSec;
			double hourAng = addHourHour + addMinHour + addSecHour;
			double minuteAng = addMinMin + addSecMin;
			

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