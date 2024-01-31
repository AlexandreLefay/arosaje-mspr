import React, { useEffect, useState } from 'react';
import {  ScrollView, Text, Button } from 'react-native';
import {  Card, } from 'react-native-paper';
import axios from "axios";
import FormatDate from "../../components/guards/FormatDate";

const GuardianshipsPage = ({ navigation }) => {

    const [guardianshipsList, setGuardianshipsList] = useState([]);
    useEffect(() => {
        // Appel API pour récupérer les gardes
        axios.get('http://localhost:9000/api/guardianships')
            .then(response => {
                const guardsData = response.data;
                // Appel API pour récupérer les plantes
                axios.get('http://localhost:9000/api/plants')
                    .then(response => {
                        const plantsData = response.data;
                        // Appel API pour récupérer les users
                        axios.get('http://localhost:9000/api/users')
                            .then(response => {
                                const usersData = response.data;
                                // Associez chaque garde à une plante
                                const updatedGuards = guardsData.map(guard => {
                                    const plant = plantsData.find(plant => plant.id === guard.plantId);
                                    const guardian = usersData.find(guardian => guardian.id === guard.guardianId);
                                    const owner  = usersData.find(owner => owner.id === guard.ownerId);
                                    return {...guard, plant: plant, guardian: guardian, owner: owner}; // Ajoutez la plante associée à chaque garde
                                });
                                setGuardianshipsList(updatedGuards);
                            })
                            .catch(error => {
                                console.error('Erreur lors de la récupération des users :', error);
                            })
                    })
                    .catch(error => {
                        console.error('Erreur lors de la récupération des plantes :', error);
                    })
            })
            .catch(error => {
                console.error('Erreur lors de la récupération des gardes :', error);
            });
    }, []);

    return (
        <ScrollView>
        <p>Liste de mes gardes (en tant qu'user 1)</p>

            {guardianshipsList.map((guardianships, index) => (
                <Card key={index} style={{ margin: 10 }}
                >
                    <Button title={guardianships.name}
                    onPress={() => navigation.navigate('Guard', {guardId: guardianships.id})}/>
                    <Text>Garde n° : {guardianships.id}</Text>
                    <Text>Propriétaire : {guardianships.owner.username}</Text>
                    <Text>Plante associée : {guardianships.plant.name} </Text>
                    <Text>Date de début de la garde : <FormatDate date={guardianships.startDate}/></Text>
                    <Text>Date de fin de la garde : <FormatDate date={guardianships.endDate}/></Text>
                </Card>
            ))}

        <Button
            title="Ajouter"
            onPress={() => navigation.navigate('AddGuardianships')}
        />

        </ScrollView>
    );

}

export default GuardianshipsPage