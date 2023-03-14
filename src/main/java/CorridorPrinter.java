public class CorridorPrinter {
    private final Console console;

    public CorridorPrinter(Console console) {
        this.console = console;
    }

    public void print(String doorState) {
        console.print("Door " + doorState);
    }
}
