package OOP.ec22827.A8;
class Room_ec22827 extends Room {
    public Direction visit(Visitor visitor, Direction entrance){
        boolean friendly = false;
        boolean lights = false;

        visitor.tell("Welcome to the dark room ec22827. Here is 5 gold for you.");
        visitor.giveGold(5);
        visitor.tell("Joking, i'm taking it back.");
        visitor.takeGold(5);

        visitor.tell("Guess which direction is the exit by clicking one of the buttons above. You have one try.");

        return entrance;
    }

}