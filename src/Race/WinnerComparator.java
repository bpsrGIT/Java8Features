package Race;

import java.util.Comparator;

public class WinnerComparator implements Comparator<Racer> {

	@Override
	public int compare(Racer o1, Racer o2) {
        if (o1.distanceTravelled > o2.distanceTravelled)
            return -1;
        else if (o1.distanceTravelled < o2.distanceTravelled)
            return 1;
        else
            return 0;
    }
}