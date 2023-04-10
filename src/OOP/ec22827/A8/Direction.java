package OOP.ec22827.A8;

class Direction {
    
    // Hide constructor so unofficial directions cannot be created.
    private Direction() {};
    
    // Destination's prespective.
    static final Direction FROM_SOUTH = new Direction();
    static final Direction FROM_WEST = new Direction();
    static final Direction FROM_NORTH = new Direction();
    static final Direction FROM_EAST = new Direction();
    
    // Origin's perspective.
    static final Direction TO_NORTH = FROM_SOUTH;
    static final Direction TO_EAST = FROM_WEST;
    static final Direction TO_SOUTH = FROM_NORTH;
    static final Direction TO_WEST = FROM_EAST;

    static final Direction UNDEFINED = new Direction();
        
    static Direction opposite(Direction d) {
        
        if (d == FROM_SOUTH) return TO_SOUTH;
        if (d == FROM_EAST)  return TO_EAST;
        if (d == FROM_NORTH) return TO_NORTH;
        if (d == FROM_WEST)  return TO_WEST;
        
        return UNDEFINED;
        
    }
} 
