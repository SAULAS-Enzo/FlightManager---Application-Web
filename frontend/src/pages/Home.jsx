import '../styles/home.css';

export function Operationnel()
{
    return (
        <article>
            <h1>Opérationnel</h1>
            <p>.</p>
            <p>.</p>
            <p>.</p>
            <p>.</p>
            <p>.</p>
        </article>
    );
}

export function Encyclopedie()
{
    return (
        <article>
            <h1>Encyclopédie</h1>
            <p>.</p>
            <p>.</p>
            <p>.</p>
            <p>.</p>
            <p>.</p>
        </article>
    );
}

export function Quizz()
{
    return (
        <article>
            <h1>Quizz</h1>
            <p>.</p>
            <p>.</p>
            <p>.</p>
            <p>.</p>
            <p>.</p>
        </article>
    );
}

export default function Home() 
{
    return (
        <main>
            <Operationnel></Operationnel> 
            <Encyclopedie></Encyclopedie>
            <Quizz></Quizz>
        </main>
    );
}