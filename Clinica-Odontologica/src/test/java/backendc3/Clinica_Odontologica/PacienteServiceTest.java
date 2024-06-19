package backendc3.Clinica_Odontologica;

import backendc3.Clinica_Odontologica.dao.BD;
import backendc3.Clinica_Odontologica.entity.Paciente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import backendc3.Clinica_Odontologica.service.PacienteService;

public class PacienteServiceTest {
    @Test
    public void buscarPacientePorID(){
        BD.crearTablas();
        PacienteService pacienteService= new PacienteService();
        Integer id=2;
        Paciente paciente= pacienteService.buscarPorID(id);
        Assertions.assertTrue(paciente!=null);
        Paciente paciente1 = pacienteService.buscarPorString(toString());
    }
}
