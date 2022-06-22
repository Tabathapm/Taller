package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Avion;
import ar.edu.unlam.tallerweb1.modelo.Hangar;
import ar.edu.unlam.tallerweb1.modelo.TipoAvion;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RepositorioAvionTest extends SpringTest {


    @Autowired
    private RepositorioAvion repositorioAvion;



    @Test
    @Transactional
    @Rollback
    public void testQueObtieneAvionesSinAsignarAHangares(){

        //given
        Hangar hangar = new Hangar();

        TipoAvion tipoAvion = new TipoAvion();
        tipoAvion.setId(10L);

        TipoAvion tipoAvion1 = new TipoAvion();
        tipoAvion.setId(110L);

        Avion avion = new Avion();
        avion.setId(1L);
        avion.setHangar(hangar);
        avion.setTipoAvion(tipoAvion);
        avion.setNombre("Logitech");

        hangar.setNombre("Olimpiaaa");
        hangar.setAvion(avion);
        hangar.setOcupado(true);
        hangar.setId(1L);


        Avion avion1 = new Avion();
        avion1.setId(11L);
        avion1.setHangar(null);
        avion1.setTipoAvion(tipoAvion1);
        avion1.setNombre("Logitech1");

        Hangar hangar2 = new Hangar();
        hangar2.setAvion(null);
        hangar2.setId(100L);
        hangar2.setOcupado(false);

        session().save(tipoAvion);
        session().save(avion);
        session().save(hangar);
        session().save(avion1);
        session().save(hangar2);

        //when
        List<Avion> aviones = repositorioAvion.verAvionesSinHangar();

        //then
        assertThat(aviones.size()).isEqualTo(1);

    }


}
