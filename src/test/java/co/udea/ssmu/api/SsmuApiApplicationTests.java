package co.udea.ssmu.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SsmuApiApplicationTests {


    //Crear test basico que pase para verificar que la aplicacion se levanta correctamente
    @Test
    public void testSum() {
        int a = 5;
        int b = 10;
        int result = a + b;
        assertEquals(15, result);
    }
    


}
