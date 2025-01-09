import {useState} from 'react';

function MyButton({count, onClick}) {
    return (
        <>
            <button onClick={onClick}>
                Clicked {count} times
            </button>
            <br/>
        </>
    );
}

function MyApp() {
    const [count, setCount] = useState(0);

    function handleClick() {
        setCount(count + 1);
    }
    return (
        <div>
            <h1>Counters that update separately</h1>
            <MyButton count={count} onClick={handleClick}/>
            <MyButton count={count} onClick={handleClick}/>
        </div>
    );
}

const user = {
    name: 'Hedy Lamarr',
    imageUrl: 'https://i.imgur.com/yXOvdOSs.jpg',
    imageSize: 90,
};

function Profile() {
    return (
        <>
            <h1>{user.name}</h1>
            <img
                className="avatar"
                src={user.imageUrl}
                alt={'Photo of ' + user.name}
                style={{
                    width: user.imageSize,
                    height: user.imageSize
                }}
            />
        </>
    );
}

const products = [
    {title: 'Cabbage', isFruit: false, id: 1},
    {title: 'Garlic', isFruit: false, id: 2},
    {title: 'Apple', isFruit: true, id: 3},
];

function Items() {
    const listItems = products.map(product =>
        <li key={product.id}>
            {product.title}
        </li>
    );
    return (
        <ul>{listItems}</ul>
    );
}

function ShoppingList() {
    const listItems = products.map(product =>
        <li
            key={product.id}
            style={{
                color: product.isFruit ? 'magenta' : 'darkgreen'
            }}
        >
            {product.title}
        </li>
    );
    return (
        <ul>{listItems}</ul>
    );
}

export default function All() {
    return (
        <div>
            <MyApp/>
            <Profile/>
            <Items/>
            <ShoppingList/>
        </div>
    );
}
