import '../styles/global.css';

const user = "Se connecter"; //TODO Connexion


export default function Header()
{
    return (
        <header>
        <div>
            <img src="../assets/img/logos/logo_avion.png" alt=""/>
            <h1>Flight manager</h1>
        </div>
        <div>
            <button type="button" class="user-button" onclick={""}>
                <img src="../assets/img/icons/utilisateur.png" alt=""/>
                <p>{user}</p>
            </button>
            
        </div>
    </header>
    );
}