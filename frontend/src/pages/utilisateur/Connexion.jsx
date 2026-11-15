import '../../styles/utilisateur.css';

function Connexion (){
    return (
        <main>
            <section>
                <form action="/req/login" method="post">
                    <h1>Connexion</h1>
                    <div class="dialog-row">
                        <label th:if="${param.error}" th:text="${session['SPRING_SECURITY_LAST_EXCEPTION'].message}" class="text-center redText"></label>                   
                    </div>
                    <div class="inputbox">
                        <ion-icon name="email-outline"></ion-icon>
                        <input name="nomUtilisateur" id="nomUtilisateur" type="name" required/>
                        <label htmlfor="">Nom d'utilisateur</label>
                    </div>
                    <div class="inputbox">
                        <ion-icon name="lock-closed-outline"></ion-icon>
                        <input name="motDePasse" id="moDePasse" type="password" required/>
                        <label htmlFor="">Mot de passe</label>
                    </div>
                    <div class="register">
                        <p><a href="#">Mot de passe oublié ?</a></p>
                    </div>
                    <button class="bouton-se-connecter">Se connecter</button>
                    <div class="register">
                        <p>Vous n'avez pas de compte ? <a href="/inscription">Inscrivez-vous !!</a></p>
                    </div>
                </form>
            </section>
        </main>
    );
}

export default Connexion;