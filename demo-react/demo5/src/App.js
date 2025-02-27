import React, {useState} from 'react';

function Header({ title }) {
    return (
        <h1>{title}</h1>
    );
}

function HomePage() {
    const names = ['Ada Lovelace', 'Grace Hopper', 'Margaret Hamilton'];
    const [likes, setLikes] = useState(0);
    function handleClick() {
        setLikes(likes + 1);
    }
    return (
        <div>
            <Header title="Develop. Preview. Ship." />
            <ul>
                {names.map((name) => (
                    <li key={name}>{name}</li>
                ))}
            </ul>
            <button onClick={handleClick}>Likes ({likes})</button>
        </div>
    );
}

export default function All() {
    return (
        <>
            <HomePage/>
        </>
    );
}
