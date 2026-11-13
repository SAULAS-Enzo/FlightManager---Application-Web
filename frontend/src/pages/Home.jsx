import '../styles/home.css';

function Operationnel()
{
    return (
        <button type="button" class="article-button">
            <article>
                <h1>OPERATIONNEL</h1>
                <img src="../assets/img/icons/aeroport2.png"/>
                <h2>Créer, importer, exporter et enregistrer son plan de vol</h2>
                <br />
                <p>Possède tous les outils nécessaires à la réalisation d'un plan de vol :</p>
                <ul>
                    <li>Spécifications de l'avion</li>
                    <li>Communication avec les ATC</li>
                    <li>Informations météorologiques actuelles</li>
                    <li>Route à suivre & radiocommunications</li>
                    <li>Calculateur</li>
                    <li>Cartes VAC</li>
                    <li>Mes documents propres à mon avions</li>
                </ul>
            </article>
        </button>
        
    );
}

function Encyclopedie()
{
    return (
        <button type="button" class="article-button">
            <article>
                <h1>ENCYPLOPEDIE</h1>
                <img src="../assets/img/icons/reserver-un-avion.png"/>
                <h2>Apprener, marquer, enregistrer des fiches existantes.</h2>
                <br  />
                <p>Réunit l'ensemble des fiches courtes pour chaque sujet :</p>
                <ul>
                    <li>Accéder aux fiches existantes provenant des ressources d'IVAO</li>
                    <li>Ajouter ses propres fiches aux format PDF</li>
                    <li>Ajouter des fiches à ses favoris</li>
                    <li>Marquer des fiches comprennant des erreurs</li>
                </ul>
            </article>
        </button>
    );
}

function Quizz()
{
    return (
        <button type="button" class="article-button">
            <article>
                <h1>QUIZZ</h1>
                <img src="../assets/img/icons/passeport.png"/>
                <h2>Tester ses connaisances pour se préparer aux examens IVAO</h2>
                <p>Réunit un emsemble de quizz pour tester ses connaisances et ce préparer au mieux aux examens d'IVAO.</p>
                <p>Ceci grâce à une série de QCM dèjà fait pour chaque thématiques et pour chaque examen de FS3 à PP</p>
            </article>
        </button>
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