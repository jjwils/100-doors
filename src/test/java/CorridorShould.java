import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CorridorShould {

    @Mock
    CorridorPrinter corridorPrinter;

    @Test
    void open_all_doors_on_first_pass(){
        Corridor corridor = new Corridor(100, corridorPrinter);
        corridor.pass(0);

        assertTrue(corridor.open());
        assertTrue(corridor.open(1));
        assertTrue(corridor.open(2));


    }

    @Test
    void toggle_every_other_door() {

        //all doors start closed
        Corridor corridor = new Corridor(5, corridorPrinter);
        //open every other door starting with door 2
        corridor.pass(1);

        assertFalse(corridor.open(1));
        assertTrue(corridor.open(2));


    }
    @Test
    void print_state(){

        Console console = new Console();
        Corridor corridor = new Corridor(1, corridorPrinter);

        corridor.print();

        verify(corridorPrinter).print("1: Closed");

    }






}