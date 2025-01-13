import {useState} from 'react';

function ClientsTable({products}) {
    const [filterText, setFilterText] = useState('fruit');
    const [inStockOnly, setInStockOnly] = useState(false);
    return (
        <div>
        </div>
    );
}

const PRODUCTS = [
    {category: "Fruits", price: "$1", stocked: true, name: "Apple"},
    {category: "Fruits", price: "$1", stocked: true, name: "Dragonfruit"},
    {category: "Fruits", price: "$2", stocked: false, name: "Passionfruit"},
    {category: "Vegetables", price: "$2", stocked: true, name: "Spinach"},
    {category: "Vegetables", price: "$4", stocked: false, name: "Pumpkin"},
    {category: "Vegetables", price: "$1", stocked: true, name: "Peas"}
];

export default function App() {
    return <ClientsTable products={PRODUCTS} />;
}
