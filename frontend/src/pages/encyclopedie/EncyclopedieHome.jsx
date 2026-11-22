import '../../styles/home.css';
import '../../styles/encyclopedie.css'
import Menu from './components/menu';

export default function EncyclopedieHome()
{

    return (
        <main className="encyclopedie-layout">
            <Menu />
            <section>
                <h1>Mes favoris</h1>
            </section>
        </main>
    );
}

