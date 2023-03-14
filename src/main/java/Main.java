public class Main {

    public static void main(String[] args) {
        Corridor corridor = new Corridor(100, new CorridorPrinter(new Console()));

        corridor.print();

        for (int i = 0; i < 100; i++) {
            System.out.println("Pass " + (i+1));
            corridor.pass(i);
            corridor.print();

        }




    }
}
