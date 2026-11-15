import '../../styles/utilisateur.css';
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { inscrireUtilisateur } from './service/InscriptionService.js';

function Inscription() {
    const navigate = useNavigate();
    const [erreur, setErreur] = useState('');
    const [envoiEnCours, setEnvoiEnCours] = useState(false);

    async function handleSubmit(event) {
        event.preventDefault();
        setErreur('');

        const formData = new FormData(event.currentTarget);
        const motDePasse = formData.get('motDePasse');
        if (motDePasse !== formData.get('confirmMotDePasse')) {
            setErreur('Les mots de passe ne correspondent pas.');
            return;
        }

        setEnvoiEnCours(true);
        try {
            await inscrireUtilisateur({
                nomUtilisateur: formData.get('nomUtilisateur'),
                adresseMail: formData.get('email'),
                motDePasse
            });
            navigate('/connexion', { state: { message: 'Votre compte a été créé. Vous pouvez vous connecter.' } });
        } catch (error) {
            setErreur(error.message || 'Impossible de créer le compte. Vérifiez votre connexion.');
        } finally {
            setEnvoiEnCours(false);
        }
    }

    return (
        <main>
            <section>
                <form onSubmit={handleSubmit}>
                    <h1>Inscription</h1>
                    <div className="inputbox">
                        <ion-icon name="person-outline"></ion-icon>
                        <input type="text" id="nomUtilisateur" name="nomUtilisateur" autoComplete="username" required/>
                        <label htmlFor="nomUtilisateur">Nom d'utilisateur</label>
                    </div>
                    <div className="inputbox">
                        <ion-icon name="mail-outline"></ion-icon>
                        <input type="email" id="email" name="email" autoComplete="email" required/>
                        <label htmlFor="email">Email</label>
                    </div>

                    <div className="inputbox">
                        <ion-icon name="lock-closed-outline"></ion-icon>
                        <input type="password" id="motDePasse" name="motDePasse" autoComplete="new-password" required/>
                        <label htmlFor="motDePasse">Mot de passe</label>
                    </div>
                    <div className="inputbox">
                        <ion-icon name="lock-closed-outline"></ion-icon>
                        <input type="password" id="confirmMotDePasse" name="confirmMotDePasse" autoComplete="new-password" required/>
                        <label htmlFor="confirmMotDePasse">Confirmez le mot de passe</label>
                    </div>
                    {erreur && <p className="form-error" role="alert">{erreur}</p>}
                    <button className="bouton-se-connecter" id="submit" type="submit" disabled={envoiEnCours}>
                        {envoiEnCours ? 'Inscription en cours…' : 'Inscrivez-vous'}
                    </button>
                    <div className="register">
                        <p>Vous avez déjà un compte ? <a href="/connexion">Connectez-vous</a></p>
                    </div>
                </form>
            </section>
        </main>
        
    );
}

export default Inscription;