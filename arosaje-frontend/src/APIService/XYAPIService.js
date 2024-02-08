class XYAPIService {
    x: number;
    y: number;

    constructor(street: string, zip: string, city: string ) {
        //utilisation API : https://adresse.data.gouv.fr/api-doc/adresse
        // => retourne coordonées d'apres adresse
        const streetWithoutBlank: string = street.replace(/ /g, "%20")
        const cityWithoutBlank: string = city.replace(/ /g, "%20")

        fetch(URL + streetWithoutBlank + '%2C%20' + cityWithoutBlank + '&type=housenumber').then(response => {
            if (!response.ok) {
                throw new Error('La requête a échoué');
            }
            return response.json();
        })
            .then(data => {
                this.x = data.features[0].geometry.coordinates[0];
                this.y= data.features[0].geometry.coordinates[1];
            }) .catch(error => {
                console.log("Erreur lors de la récupération des coordonnées : " + error);
                this.x =0;
                this.y= 0;
        });
    }
}