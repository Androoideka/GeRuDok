package helpers;

import java.awt.Dimension;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

public class UserSpaceScaler {
	public static double defaultResX = 1664; 
	public static double defaultResY = 936;
	private static UserSpaceScaler instance = null;

	private UserSpaceScaler() {
		// TODO Auto-generated constructor stub
	}
	
	public static UserSpaceScaler getInstance() {
		if(instance == null) {
			instance = new UserSpaceScaler();
		}
		return instance;
	}
	
	public Point2D toUserSpace(Point2D point, Dimension size) {
		Point2D userSpacePoint = (Point2D)point.clone();
		AffineTransform at = AffineTransform.getScaleInstance(size.getWidth() / defaultResX, size.getHeight() / defaultResY);
		try {
			at.inverseTransform(point, userSpacePoint);
		}
		catch (Exception e) {
			System.out.println("kk");
		}
		return userSpacePoint;
	}
}
