package exercises;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class EmployeeWrapperTest {

    @Test
    void testGetPareigos() {
        // cia kur yra return type.
        Person person = mock(Person.class);
        when(person.getName()).thenReturn("Vladyslavas");

        // su voidais
//        when(person.getName()).thenThrow(NullPointerException.class);
//        doNothing().when(person.getName());

        EmployeeWrapper employeeWrapper = new EmployeeWrapper("id10", "docentas", 4, person, null);
        assertEquals("docentas", employeeWrapper.getPareigos());
        assertEquals("Vladyslavas", employeeWrapper.getPerson().getName());
        verify(person, times(1)).getName();
    }
}
