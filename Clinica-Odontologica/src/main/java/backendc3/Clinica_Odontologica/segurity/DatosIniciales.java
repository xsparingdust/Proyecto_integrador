package backendc3.Clinica_Odontologica.segurity;

import backendc3.Clinica_Odontologica.entity.Usuario;
import backendc3.Clinica_Odontologica.entity.UsuarioRole;
import backendc3.Clinica_Odontologica.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DatosIniciales implements ApplicationRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        String passSinCifrar= "admin";
        String passCifrado=  passwordEncoder.encode(passSinCifrar);
        Usuario usuario= new Usuario("jorgito","jpereryradh","admin@admin.com",passCifrado, UsuarioRole.ROLE_USER);
        usuarioRepository.save(usuario);
    }
}
