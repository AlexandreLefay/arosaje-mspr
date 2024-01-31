import React, { useEffect, useState } from 'react';
import {ScrollView, Text, Button, TouchableOpacity} from 'react-native';
import {  Card, } from 'react-native-paper';
import axios from "axios";
import FormatDate from "../../components/guards/FormatDate";
import {Style} from "../../components/Style";
import {getGuardByUserId} from "../../api/GuardianshipsAPI/GuardiashipsAPI";


const MyGuardsPage = ({ navigation }) => {

    const [guardianshipsList, setGuardianshipsList] = useState([]);
    useEffect(() => {
        // Appel API pour récupérer les gardes
        axios.get('http://localhost:9000/api/guardianships/user/{ownerUserId}?ownerUserId=1')
            .then(response => {
                const guardsData = response.data;
                console.log(guardsData)
                // Appel API pour récupérer les plantes
                axios.get('http://localhost:9000/api/plants')
                    .then(response => {
                        const plantsData = response.data;
                        console.log(plantsData)
                        // Appel API pour récupérer les users
                        axios.get('http://localhost:9000/api/users')
                            .then(response => {
                                const usersData = response.data;
                                console.log(usersData)
                                // Associez chaque garde à une plante
                                const updatedGuards = guardsData.map(guard => {
                                    const plant = plantsData.find(plant => plant.id === guard.plantId);
                                    const guardian = guard.id ? usersData.find(guardian => guardian.id === guard.guardianId) : null
                                    const owner  = usersData.find(owner => owner.id === guard.ownerId);
                                    return {...guard, plant: plant, guardian: guardian, owner: owner};
                                });
                                setGuardianshipsList(updatedGuards);console.log("coucou")
                              console.log(getGuardByUserId.guard)
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
        <ScrollView style={Style.container}>
            <p>Liste de mes gardes (en tant qu'user 1)</p>

                {guardianshipsList.map((guardianships, index) => (
                    <Card key={index} style={Style.container}>
                      <TouchableOpacity onPress={() => navigation.navigate('Guard', {guardId: guardianships.id})}  title='MyGardsPage'>
                        <Text title={guardianships.title}
                                onPress={() => navigation.navigate('guard', {guardId: guardianships.id})}>{guardianships.title}</Text>
                        <Text>Propriétaire : {guardianships.owner.username}</Text>
                        <Text>Plante associée : {guardianships.plant.name} </Text>
                        <Text>Du <FormatDate date={guardianships.startDate}/> au <FormatDate date={guardianships.endDate}/></Text>
                            {guardianships.guardian !== '2' ? (
                              <Text>Gardé par : { guardianships.guardian.username } </Text>) : (<Text>Gardien à trouver !!! </Text>
                        )}
                      </TouchableOpacity>
                    </Card>
                ))}
        </ScrollView>
    );
}
export default MyGuardsPage