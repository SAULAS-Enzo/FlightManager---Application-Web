import '../../styles/utilisateur.css';
import { useState } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';
import { connecterUtilisateur } from './service/InscriptionService.js';

function Connexion (){
    const navigate = useNavigate();
    const location = useLocation();
    const [erreur, setErreur] = useState('');
    const [envoiEnCours, setEnvoiEnCours] = useState(false);
    const message = location.state?.message || '';

    async function handleSubmit(event) {
        event.preventDefault();
        setErreur('');
        setEnvoiEnCours(true);

        const formData = new FormData(event.currentTarget);
        try {
            await connecterUtilisateur({
                nomUtilisateur: formData.get('nomUtilisateur'),
                motDePasse: formData.get('motDePasse')
            });
            navigate('/profile');
        } catch (error) {
            setErreur(error.message || 'Impossible de se connecter. Vérifiez votre connexion.');
        } finally {
            setEnvoiEnCours(false);
        }
    }

    return (
        <main>
            <section>
                <form onSubmit={handleSubmit}>
                    <h1>Connexion</h1>
                    {message && <p role="status">{message}</p>}
                    <div className="inputbox">
                        <ion-icon name="email-outline"></ion-icon>
                        <input name="nomUtilisateur" id="nomUtilisateur" type="text" autoComplete="username" required/>
                        <label htmlFor="nomUtilisateur">Nom d'utilisateur</label>
                    </div>
                    <div className="inputbox">
                        <ion-icon name="lock-closed-outline"></ion-icon>
                        <input name="motDePasse" id="motDePasse" type="password" autoComplete="current-password" required/>
                        <label htmlFor="motDePasse">Mot de passe</label>
                    </div>
                    {erreur && <p className="form-error" role="alert">{erreur}</p>}
                    <button className="bouton-se-connecter" type="submit" disabled={envoiEnCours}>
                        {envoiEnCours ? 'Connexion en cours…' : 'Se connecter'}
                    </button>
                    <div className="register">
                        <p>Vous n'avez pas de compte ? <a href="/inscription">Inscrivez-vous !!</a></p>
                    </div>
                </form>
            </section>
        </main>
    );
}

export default Connexion;