import '../styles/global.css';
import { useNavigate } from 'react-router-dom';

const user = "Se connecter"; //TODO Connexion


export default function Header()
{
    const navigate = useNavigate();

    return (
        <header>
            
            <button 
              type="button" 
              className="article-button" 
              onClick={() => navigate('/home')}
            >
                <div className="header-brand">
                    <img src="../assets/img/logos/logo_avion.png" alt=""/>
                    <h1>Flight manager</h1>
                </div>
            </button>
        
            <div>
                <button type="button" class="user-button" onclick={""}>
                    <img src="../assets/img/icons/utilisateur.png" alt=""/>
                    <p>{user}</p>
                </button>
            </div>
        </header>
    );
}