import React, {useState} from 'react';

function Header({title}) {
    return (
        <h1>{title}</h1>
    );
}

function LikeButton() {
    const [likes, setLikes] = useState(0);

    function handleClick() {
        setLikes(likes + 1);
    }

    return (
        <button onClick={handleClick}>Like ({likes})</button>
    );
}

function HomePage() {
    const names = ['Ada Lovelace', 'Grace Hopper', 'Margaret Hamilton'];
    return (
        <div>
            <Header title="Develop. Preview. Ship."/>
            <ul>
                {names.map((name) => (
                    <li key={name}>{name}</li>
                ))}
            </ul>
            <LikeButton/>
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
