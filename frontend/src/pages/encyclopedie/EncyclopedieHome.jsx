import '../../styles/home.css';
import '../../styles/encyclopedie.css'
import { useNavigate } from 'react-router-dom';
import Menu from './components/menu';

export default function EncyclopedieHome()
{
    const navigate = useNavigate();

    return (
        <main className="encyclopedie-layout">
            <Menu />
            <section>
                <h1>Mes favoris</h1>
            </section>
        </main>
    );
}

