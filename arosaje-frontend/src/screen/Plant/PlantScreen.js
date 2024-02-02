import React, {useEffect, useState} from 'react';
import {ScrollView, Text} from 'react-native';
import {getPlants} from "../../api/plant/PlantAPI";

function PlantScreen() {
    const [plants, setPlants] = useState([]);

    useEffect(() => {
        getPlants().then(response => {
            setPlants(response.data);
        });
    }, []);

    return (
        <ScrollView style={{flex: 1}}>
            <Text style={{margin: 10}}>LISTE DES PLANTES</Text>
            {plants.map(plant => (
                <Text key={plant.id} style={{margin: 10}}>
                    {plant.name}
                </Text>
            ))}
        </ScrollView>
    );
}

export default PlantScreen;
