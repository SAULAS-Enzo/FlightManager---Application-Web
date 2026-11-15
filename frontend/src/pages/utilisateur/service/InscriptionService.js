async function readResponse(response) {
    const body = await response.json();

    if (!response.ok) {
        throw new Error(body.message || 'Une erreur est survenue.');
    }

    return body;
}

export async function inscrireUtilisateur({ nomUtilisateur, adresseMail, motDePasse }) {
    const response = await fetch('/req/inscription', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ nomUtilisateur, adresseMail, motDePasse })
    });

    return readResponse(response);
}

export async function connecterUtilisateur({ nomUtilisateur, motDePasse }) {
    const response = await fetch('/req/connexion', {
        method: 'POST',
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
        body: new URLSearchParams({ nomUtilisateur, motDePasse })
    });

    return readResponse(response);
}