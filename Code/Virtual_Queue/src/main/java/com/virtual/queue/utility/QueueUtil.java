package com.virtual.queue.utility;

public class QueueUtil {

	public QueueUtil() {

	};

	// TODO make all methods static.
	
	public double calculateDistance(double lat1, double lon1, double lat2,
			double lon2) {

		double theta = lon1 - lon2;

		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
				+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2))
				* Math.cos(deg2rad(theta));

		dist = Math.acos(dist);

		dist = rad2deg(dist);

		dist = dist * 60 * 1.1515;

		return (dist);

	}

	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */

	/* :: This function converts decimal degrees to radians : */

	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */

	private double deg2rad(double deg) {

		return (deg * Math.PI / 180.0);

	}

	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */

	/* :: This function converts radians to decimal degrees : */

	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */

	private double rad2deg(double rad) {

		return (rad * 180 / Math.PI);

	}


	public static int getWaitingTime(int count, int rideCap, int duration,
			boolean topbot) {
		int wait = 0;
		if (rideCap == 0)
			return -1;
		if (topbot) {
			wait = 5;//(int) Math.floor((count / rideCap)) * duration;
		} else {
			wait = (int) Math.ceil((count / rideCap)) * duration;
		}

		return wait;

	}
	public static int getWaitingTime2(int maxGuestPerEvent,int maxConcurrentEvents, int timePerEvent, int entryTime, int exitTime,
			boolean topbot) {
		int wait = 0;
		if (maxGuestPerEvent == 0)
			return -1;
		if (topbot) {
			wait = (maxGuestPerEvent* maxConcurrentEvents)/(timePerEvent+entryTime+exitTime);
		} else {
			wait = (maxGuestPerEvent* maxConcurrentEvents)/(timePerEvent+entryTime+exitTime);
		}

		return wait;

	}
	
}