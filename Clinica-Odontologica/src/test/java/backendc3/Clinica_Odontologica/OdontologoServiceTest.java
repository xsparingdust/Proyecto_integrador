package backendc3.Clinica_Odontologica;

import backendc3.Clinica_Odontologica.dao.BD;
import backendc3.Clinica_Odontologica.entity.Odontologo;
import backendc3.Clinica_Odontologica.service.OdontologoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class OdontologoServiceTest {
    private OdontologoService odontologoService;

    @BeforeEach
    public void setUp() {
        BD.crearTablas();
        odontologoService = new OdontologoService();


    }

    @Test
    public void testGuardarOdontologo() {
        Odontologo odontologo = new Odontologo("12345", "Juan", "Perez");
        Odontologo odontologoGuardado = odontologoService.guardarOdontologo(odontologo);
        assertNotNull(odontologoGuardado);
        assertNotNull(odontologoGuardado.getId());
    }

    @Test
    public void testBuscarTodos() {
        // Insertar algunos odontólogos para probar el listado
        odontologoService.guardarOdontologo(new Odontologo("12345", "Juan", "Perez"));
        odontologoService.guardarOdontologo(new Odontologo("67890", "Ana", "Garcia"));

        List<Odontologo> odontologos = odontologoService.buscarTodos();
        assertNotNull(odontologos);
       assertTrue(odontologos.size() >= 2);
    }

    @Test
    public void buscarOdontologoPorID(){
        BD.crearTablas();
        OdontologoService odontologoService = new OdontologoService();
        Integer id=2;
        Odontologo odontologo= odontologoService.buscarPorID(id);
        Assertions.assertFalse(odontologo!=null);


    }
}