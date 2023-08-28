package com.epicode.fire.model;

import java.time.LocalDateTime;
import java.util.Observable;

public class Sensor extends Observable {
    private static String latitude;
    private static String longitude;
    private static int smokeQuantity;
    private static LocalDateTime date;
    private static String area;

    public void setSmoke(String latitude, String longitude, int smokeQuantity, LocalDateTime localDate, String area) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.smokeQuantity = smokeQuantity;
        this.date = localDate;
        this.area = area;

        relievedSmoke();
    }

    private void relievedSmoke() {
        
    }

	public static String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public static String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public static int getSmokeQuantity() {
		return smokeQuantity;
	}

	public void setSmokeQuantity(int smokeQuantity) {
		this.smokeQuantity = smokeQuantity;
	}

	public static LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public static String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	
	 
	 @Override
		public String toString() {
			return "FirstSensor [latitude=" + latitude + ", longitude=" + longitude + ", area=" + area + ", smokeQuantity="
					+ smokeQuantity + ", date=" + date + "]";
		}
}

