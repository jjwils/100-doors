public class Corridor {


    final boolean[] doors;
    private final CorridorPrinter corridorPrinter;

    public Corridor(int doors, CorridorPrinter corridorPrinter) {
        this.corridorPrinter = corridorPrinter;

        //all shut to start
        this.doors = new boolean[doors];
    }

    public void pass(int skip) {

        for (int i = skip; i < doors.length; i = i + skip + 1) {
            //toggle the door
            doors[i] = !doors[i];
        }
    }

    /**
     * Checks the state of all doors in the corridor 
     * @return true is all doors in the corridor are apen
     * @param i
     */
    public boolean open() {

            for (int i = 0; i < doors.length - 1; i++) {
                if (!doors[i]) {
                    return false;

                }

            }

        return true;
    }

    public void print() {

        for (int i = 0; i < doors.length; i++) {
        corridorPrinter.print(i+1 + ": " + (doors[i]?"Open":"Closed"));

        }
    }

    public boolean open(int door) {
        return doors[door-1];

    }
}
