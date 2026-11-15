import '../../styles/utilisateur.css';

function Inscription() {
    return (
        <main>
            <section>
                <form action="/req/signup" method="post">
                    <h1>Inscription</h1>
                    <div class="inputbox">
                        <ion-icon name="person-outline"></ion-icon>
                        <input type="text" id="nomUtilisateur" name="nomUtilisateur" required/>
                        <label for="">Nom</label>
                    </div>
                    <div class="inputbox">
                        <ion-icon name="mail-outline"></ion-icon>
                        <input type="email" id="email" name="email" required/>
                        <label for="">Email</label>
                    </div>

                    <div class="inputbox">
                        <ion-icon name="lock-closed-outline"></ion-icon>
                        <input type="password" id="motDePasse" name="motDePasse" required/>
                        <label for="">Mot de passe</label>
                    </div>
                    <div class="inputbox">
                        <ion-icon name="lock-closed-outline"></ion-icon>
                        <input type="password" id="confirmMotDePasse" name="confirmMotDePasse" required/>
                        <label for="">Confirmez le mot de passe</label>
                    </div>
                    <button class="bouton-se-connecter" id="submit" type="submit">Inscrivez-vous</button>
                    <div class="register">
                        <p>Vous avez déjà un compte ? <a href="/connexion">Connectez-vous</a></p>
                    </div>
                </form>
            </section>
        </main>
        
    );
}

export default Inscription;