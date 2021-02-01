package io.github.mrxbox98.notenoughupdatesExtra;

import java.util.ArrayList;

public class Room {

    private Shape shape;
	
    private int secrets;

    private String name;
    
    private IdentifyBlocks blocks;

    public static ArrayList<Room> rooms = new ArrayList<Room>();
    
    public static void addRooms()
    {
    	rooms.add(new Room(Shape.ROOM1X1,1,"banners"));
    }

    
    /**
     * Creates a new room instance
     * 
     * @param shape Shape of the dungeon room
     * 
     * @param secrets number of secrets
     * 
     * @param name name of the room
     * 
     */
    public Room(Shape shape, int secrets, String name)
    {
        this.shape=shape;
        this.secrets=secrets;
        this.name=name;
    }

    public Room getRoom()
    {
        return this;
    }

    
    
    public Shape getShape()
    {
    	return shape;
    }

	/**
	 * @return the secrets
	 */
	public int getSecrets() {
		return secrets;
	}

	/**
	 * @param secrets the secrets to set
	 */
	public void setSecrets(int secrets) {
		this.secrets = secrets;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public boolean equals(Room obj)
    {
    	return false;
    }
	
	
    
}