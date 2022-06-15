package ar.edu.unlam.tallerweb1.servicios;
import ar.edu.unlam.tallerweb1.modelo.Hangar;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioHangar;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(locations= "classpath:applicationContext.xml")
public class ServicioHangarTest {

    @Mock
    private RepositorioHangar repositorioHangar;

    @InjectMocks
    private ServicioHangar servicioHangar = new ServicioHangarImpl();



    @Test
    public void testQuetraeTodosLosHangares(){


        whenTraerTodosLosHangares();

        thenTraerTodosLosHangaresEsExitoso();

    }

    private void thenTraerTodosLosHangaresEsExitoso() {
        assertThat(servicioHangar.traerTodosLosHangares().size()).isEqualTo(1);
    }

    private void whenTraerTodosLosHangares() {

        when(servicioHangar.traerTodosLosHangares()).thenReturn(Arrays.asList(new Hangar()));

    }


    @Test
    public void testQueTraeHangaresVacios(){



    }

}

}
