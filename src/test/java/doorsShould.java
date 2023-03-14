import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class doorsShould {

    @Mock
    Console console;
    @Test
        void all_be_closed_at_start() {

        CorridorPrinter corridorPrinter = new CorridorPrinter(console);
        Corridor corridor = new Corridor(100, corridorPrinter);

        corridor.print();

        InOrder inOrder = inOrder(console, console, console);

        inOrder.verify(console).print("Door 1: Closed");
        inOrder.verify(console).print("Door 2: Closed");
        inOrder.verify(console).print("Door 3: Closed");

        verify(console, times(100)).print(any());


    }

    @Test
    void all_be_open_after_first_pass() {

        CorridorPrinter corridorPrinter = new CorridorPrinter(console);
        Corridor corridor = new Corridor(100, corridorPrinter);

        corridor.pass(0);
        corridor.print();

        InOrder inOrder = inOrder(console, console, console);

        inOrder.verify(console).print("Door 1: Open");
        inOrder.verify(console).print("Door 2: Open");
        inOrder.verify(console).print("Door 3: Open");

        verify(console, times(100)).print(any());

    }

    @Test
    void every_other_door_open_after_2nd_pass() {

        CorridorPrinter corridorPrinter = new CorridorPrinter(console);
        Corridor corridor = new Corridor(100, corridorPrinter);

        corridor.pass(0);
        corridor.pass(1);
        corridor.print();

        InOrder inOrder = inOrder(console, console, console);

        inOrder.verify(console).print("Door 1: Open");
        inOrder.verify(console).print("Door 2: Closed");
        inOrder.verify(console).print("Door 3: Open");
        inOrder.verify(console).print("Door 4: Closed");

        verify(console, times(100)).print(any());



    }




}
