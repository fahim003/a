package OOP.ec22827.A8;

public class A8_ec22827 {

    public static void main(String[] args) {

        Visitable r = new Room_ec22827();
        Visitor v = new GUI(System.out, System.in);
        r.visit(v, Direction.FROM_SOUTH);

    }
}
