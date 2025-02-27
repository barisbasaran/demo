import {useState} from 'react';

function Header() {
    return (
        <h1>Hello!</h1>
    );
}

function HomePage() {
    const homepage = "home";
    return (
        <div id={homepage}>
            {/* Nesting the Header component */}
            <Header />
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
