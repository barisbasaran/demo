import {useState, useEffect} from 'react';

function ClientRow({client}) {
    return (
        <tr>
            <td>{client.name}</td>
            <td>{client.email}</td>
        </tr>
    );
}

function ClientsTable({clients}) {
    const rows = [];
    clients.forEach((client) => {
        rows.push(
            <ClientRow
                client={client}
                key={client.id}/>
        );
    });
    return (
        <table>
            <thead>
            <tr>
                <th>Name</th>
                <th>Email</th>
            </tr>
            </thead>
            <tbody>{rows}</tbody>
        </table>
    );
}

async function fetchClients() {
    try {
        const response = await fetch("http://localhost:8080/clients");
        const clients = await response.json();
        return clients;
    } catch (error) {
        console.error("Error fetching clients", error);
        return [];
    }
}

export default function App() {
    const [clients, setClients] = useState([]);

    useEffect(() => {
        fetchClients().then((clients) => {
            setClients(clients);
        });
    }, [] )
    return <ClientsTable clients={clients}/>;
}
