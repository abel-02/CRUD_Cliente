let idCLiente = 0;

document.addEventListener("DOMContentLoaded", function() {
    cargarClientes();
});

async function cargarClientes() {
    const response = await fetch('http://localhost:8080/api/cliente/todos');
    const clientes = await response.json();

    const tbody = document.querySelector('#clientes-table tbody');
    tbody.innerHTML = ''; // Asegúrate de que solo se borra el contenido del tbody

    let cantidadClientes;

    clientes.forEach(cliente => {
        const tr = document.createElement('tr');
        tr.innerHTML = `
            <td>${cliente.id}</td>
            <td>${cliente.nombre}</td>
            <td>${cliente.apellido}</td>
            <td>${cliente.email}</td>
            <td>${cliente.direccion}</td>
            <td>
                <button onclick="editarCliente(${cliente.id})">Editar</button>
                <button onclick="eliminarCliente(${cliente.id})">Eliminar</button>
            </td>
        `;
        tbody.appendChild(tr);
        cantidadClientes++;
        
    });

    idCLiente = cantidadClientes;
}

async function editarCliente(id) {
    const cliente = {
        id: id,
        nombre: prompt("Nombre:"),
        apellido: prompt("Apellido:"),
        email: prompt("Email:"),
        direccion: prompt("Dirección:")
    };

    await fetch(`http://localhost:8080/api/cliente`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(cliente)
    });

    cargarClientes();
}

async function eliminarCliente(id) {
    await fetch(`http://localhost:8080/api/cliente/${id}`, {
        method: 'DELETE'
    });

    cargarClientes();
}

async function agregarCliente() {
    const cliente = {
        id: idCLiente + 1,
        nombre: prompt("Nombre:"),
        apellido: prompt("Apellido:"),
        email: prompt("Email:"),
        direccion: prompt("Dirección:")
    };

    await fetch(`http://localhost:8080/api/cliente`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(cliente)
    });

    cargarClientes();
}
