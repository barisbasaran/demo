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
                key={client.id} />
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

export default function App() {
    const [clients, setClients] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            const response = await fetch("http://localhost:8080/clients")
                .then((response) => response.json())
                .then((data) => setClients(data));
        };
        fetchData();
    }, []);

    return <ClientsTable clients={clients} />;
}
