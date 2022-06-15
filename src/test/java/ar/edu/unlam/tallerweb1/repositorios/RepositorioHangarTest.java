package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Avion;
import ar.edu.unlam.tallerweb1.modelo.Hangar;
import ar.edu.unlam.tallerweb1.modelo.TipoAvion;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

public class RepositorioHangarTest extends SpringTest {

    @Autowired
    private RepositorioHangar repositorioHangar;

    @Test
    @Transactional
    @Rollback
    public void testQueTraeTodosLosHangaresVacios(){

        givenSeInsertanDosHangares();

        whenSeObtienenHangaresVacios();

        thenHangaresVaciosExitoso();

    }

    private void givenSeInsertanDosHangares() {
        Hangar hangar = new Hangar();
        hangar.setNombre("Olimpiaaa");
        hangar.setAvion(new Avion());
        hangar.setOcupado(false);
        hangar.setId(1L);

        Hangar hangar1 = new Hangar();
        hangar1.setNombre("Pilar Y Alma uwu");
        hangar1.setAvion(new Avion());
        hangar1.setOcupado(true);
        hangar1.setId(2L);

        Hangar hangar2 = new Hangar();
        hangar2.setNombre("El tontito de emiliano");
        hangar2.setAvion(new Avion());
        hangar2.setOcupado(false);
        hangar2.setId(3L);

        session().save(hangar);
        session().save(hangar1);
        session().save(hangar2);
    }

    private void whenSeObtienenHangaresVacios() {
        List<Hangar> hangares = repositorioHangar.obtenerHangaresVacios();
    }

    private void thenHangaresVaciosExitoso() {
        assertThat(repositorioHangar.obtenerHangaresVacios().size()).isEqualTo(2);

    }

    @Test
    @Transactional
    @Rollback
    public void testQueConsultaHangares(){

   //given
        Hangar hangar = new Hangar();
        hangar.setNombre("Olimpiaaa");
        hangar.setAvion(new Avion());
        hangar.setOcupado(false);
        hangar.setId(1L);

        Hangar hangar1 = new Hangar();
        hangar1.setNombre("Pilar Y Alma uwu");
        hangar1.setAvion(new Avion());
        hangar1.setOcupado(true);
        hangar1.setId(2L);

        Hangar hangar2 = new Hangar();
        hangar2.setNombre("El tontito de emiliano");
        hangar2.setAvion(new Avion());
        hangar2.setOcupado(false);
        hangar2.setId(3L);

        session().save(hangar);
        session().save(hangar1);
        session().save(hangar2);



        //when
        Hangar hangarEncontrado = repositorioHangar.consultarHangar(hangar.getId());


        //then
        assertThat(hangarEncontrado).isNotNull();
        assertThat(hangarEncontrado.getId()).isEqualTo(hangar.getId());

    }

//    @Test
//    @Transactional
//    @Rollback
//    public void testQueObtieneAvionesSinAsignarAHangares(){
//
//        //given
//        Hangar hangar = new Hangar();
//
//        TipoAvion tipoAvion = new TipoAvion();
//                tipoAvion.setId(10L);
//
//        TipoAvion tipoAvion1 = new TipoAvion();
//        tipoAvion.setId(110L);
//
//        Avion avion = new Avion();
//        avion.setId(1L);
//        avion.setHangar(hangar);
//        avion.setTipoAvion(tipoAvion);
//        avion.setNombre("Logitech");
//
//        hangar.setNombre("Olimpiaaa");
//        hangar.setAvion(avion);
//        hangar.setOcupado(true);
//        hangar.setId(1L);
//
//
//        Avion avion1 = new Avion();
//        avion1.setId(11L);
//        avion1.setHangar(null);
//        avion1.setTipoAvion(tipoAvion1);
//        avion1.setNombre("Logitech1");
//
//        Hangar hangar2 = new Hangar();
//        hangar2.setAvion(null);
//        hangar2.setId(100L);
//        hangar2.setOcupado(false);
//
//        session().save(tipoAvion);
//        session().save(hangar);
//        session().save(avion);
//        session().save(avion1);
//        session().save(hangar2);
//
//        //when
//        List<Avion> aviones = repositorioHangar.obtenerAvionesSinAsignar();
//
//        //then
//        assertThat(aviones.size()).isEqualTo(1);
//
//    }

    @Test
    @Transactional
    @Rollback
    public void testQueObtieneTodosLosHangaresDisponibles(){

        //given
        Hangar hangar = new Hangar();
        hangar.setId(6L);
        hangar.setOcupado(false);
        hangar.setAvion(null);

        Hangar hangar1 = new Hangar();
        hangar1.setId(8L);
        hangar1.setOcupado(true);
        hangar1.setAvion(new Avion());

        session().save(hangar);
        session().save(hangar1);

        //when
        List<Hangar> hangaresDisponibles = repositorioHangar.obtenerTodosLosHangaresDisponibles();

        //then
        assertThat(repositorioHangar.obtenerTodosLosHangaresDisponibles().size()).isEqualTo(1);


    }


//    @Test
//    @Transactional
//    @Rollback
//    public void testQueAsignaAvionAHangar(){
//
//
//    }






}
