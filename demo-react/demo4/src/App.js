import {useState, useEffect} from 'react';

function ClientRow({client, handleClick}) {
    return (
        <tr>
            <td><a href="#" onClick={() => handleClick(client.id)}>{client.name}</a></td>
            <td>{client.email}</td>
        </tr>
    );
}

function ClientsTable({clients, handleClick}) {
    const rows = [];
    clients.forEach((client) => {
        rows.push(
            <ClientRow key={client.id} client={client} handleClick={handleClick}/>
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

function ClientDetail({client, setClientId}) {
    return (
        <>
            <table>
                <tbody>
                <tr>
                    <td>Name</td>
                    <td>{client.name}</td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td>{client.email}</td>
                </tr>
                </tbody>
            </table>
            <a href="#" onClick={()=> setClientId(null)}>Back</a>
        </>
    );
}

async function fetchClients() {
    try {
        const response = await fetch("http://localhost:8080/clients");
        return await response.json();
    } catch (error) {
        console.error("Error fetching clients", error);
        return [];
    }
}

export default function App() {
    const [clients, setClients] = useState([]);
    const [clientId, setClientId] = useState(null);

    function handleClick(id) {
        setClientId(id);
    }
    useEffect(() => {
        fetchClients().then((clients) => {
            setClients(clients);
        });
    }, [])

    if (clientId !== null) {
        const client = clients.find((client) => client.id === clientId);
        return <ClientDetail client={client} setClientId={setClientId} />;
    } else {
        return <ClientsTable clients={clients} handleClick={handleClick}/>;
    }
}
