package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Avion;
import ar.edu.unlam.tallerweb1.modelo.Hangar;
import ar.edu.unlam.tallerweb1.servicios.AvionYaExistenteEnHangarException;
import ar.edu.unlam.tallerweb1.servicios.ServicioAvion;
import ar.edu.unlam.tallerweb1.servicios.ServicioHangar;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doThrow;


@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(locations= "classpath:applicationContext.xml")
public class ControladorHangarTest {

@Mock
private ServicioAvion servicioAvion;

@Mock
private ServicioHangar servicioHangar;

@InjectMocks
private ControladorHangar controladorHangar = new ControladorHangar();

private ModelAndView mav;

    @Test
    public void verHangaresVaciosTest(){

        whenObtenerVistaHangaresVacios();

        thenLaVistaEsHangaresVacios();

    }

    private void thenLaVistaEsHangaresVacios() {
        assertThat(mav.getViewName()).isEqualTo("hangares-vervacios");
        List<Hangar> listaHangares = (List<Hangar>) mav.getModel().get("hangaresVacios");
        assertThat(listaHangares.size()).isEqualTo(0);
        List<Avion> listaAviones = (List<Avion>) mav.getModel().get("avionesVacios");
        assertThat(listaAviones.size()).isEqualTo(0);
    }

    private void whenObtenerVistaHangaresVacios() {
        // EJEMPLO DE WHEN : when(servicioHangar.traerTodosLosHangaresDisponibles()).thenReturn(Arrays.asList(new Hangar(), new Hangar()));
        mav = controladorHangar.verVacios();

    }



}
