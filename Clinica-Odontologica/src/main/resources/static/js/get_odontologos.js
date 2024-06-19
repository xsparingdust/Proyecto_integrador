window.addEventListener('load', function () {

    // Función autoejecutable para cargar los datos de odontólogos
    (function() {
        const url = '/odontologos';
        const settings = {
            method: 'GET'
        };

        fetch(url, settings)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            console.log('Datos recibidos:', data); // Depuración: verificar datos recibidos

            // Recorremos los datos recibidos para construir la tabla
            data.forEach(odontologo => {
                var table = document.getElementById("odontologoTable");
                var odontologoRow = table.insertRow();
                odontologoRow.id = odontologo.id;

                // Construcción de los botones para eliminar y actualizar
                let deleteButton = '<button id="btn_delete_' + odontologo.id + '" type="button" onclick="deleteBy(' + odontologo.id + ')" class="btn btn-danger btn_delete">&times;</button>';
                let updateButton = '<button id="btn_id_' + odontologo.id + '" type="button" onclick="findBy(' + odontologo.id + ')" class="btn btn-info btn_id">' + odontologo.id + '</button>';

                // Construcción de la fila de la tabla con los datos del odontólogo
                odontologoRow.innerHTML = '<td>' + updateButton + '</td>' +
                                          '<td class="td_numeroMatricula">' + (odontologo.numeroMatricula ? odontologo.numeroMatricula.toUpperCase() : '') + '</td>' +
                                          '<td class="td_nombre">' + (odontologo.nombre ? odontologo.nombre.toUpperCase() : '') + '</td>' +
                                          '<td class="td_apellido">' + (odontologo.apellido ? odontologo.apellido.toUpperCase() : '') + '</td>' +
                                          '<td>' + deleteButton + '</td>';
            });
        })
        .catch(error => {
            console.error('Error al obtener odontólogos:', error);
        });
    })();

    // Función autoejecutable para marcar como activo el enlace de la página actual
    (function() {
        let pathname = window.location.pathname;
        const navLinks = document.querySelectorAll(".nav .nav-item a");

        navLinks.forEach(link => {
            if (pathname.includes(link.getAttribute('href'))) {
                link.classList.add("active");
            }
        });
    })();
});
