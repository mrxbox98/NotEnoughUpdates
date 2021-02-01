package io.github.mrxbox98.notenoughupdatesExtra;

public class Shape {
	
	public static final Shape ROOM1X1 = new Shape(1,1,false);
	public static final Shape ROOM1X2 = new Shape(1,2,false);
	public static final Shape ROOM1X3 = new Shape(1,3,false);
	public static final Shape ROOM1X4 = new Shape(1,4,false);
	public static final Shape ROOM2X2 = new Shape(2,2,false);
	public static final Shape ROOML = new Shape(0,0,true);
	
	
	private int length;
	private int width;
	private boolean L;
	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}
	/**
	 * @param length the length to set
	 */
	public void setLength(int length) {
		this.length = length;
	}
	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	/**
	 * @return the l
	 */
	public boolean isL() {
		return L;
	}
	/**
	 * @param l the l to set
	 */
	public void setL(boolean l) {
		L = l;
	}
	
	public Shape(int length, int width, boolean L)
	{
		if(L)
		{
			this.setLength(0);
			this.setWidth(0);
			this.setL(L);
		}
		else
		{
			this.setLength(length);
			this.setWidth(width);
			this.setL(L);
		}
	}
	
}
