import React, {useCallback, useEffect, useState} from 'react';
import {Alert, Button, Image, ScrollView, StyleSheet, Text, TouchableOpacity, View} from 'react-native';
import axios from "axios";
import {useFocusEffect, useNavigation} from "@react-navigation/native";
import {AntDesign} from '@expo/vector-icons';

const PlantScreen = () => {
    const navigation = useNavigation();
    const [plants, setPlants] = useState([]);

    useFocusEffect(
        useCallback(() => {
            axios.get('http://192.168.1.37:9000/api/plants/user/1')
                .then((response) => {
                    const updatedPlants = response.data.map(plant => {
                        if (plant.photos && plant.photos.length > 0) {
                            const imageBlob = `data:image/jpeg;base64,${plant.photos[0].imageBlob}`;
                            return {...plant, imageBlob};
                        }
                        return plant;
                    });
                    setPlants(updatedPlants);
                })
                .catch((error) => {
                    console.log(error);
                });
        }, [])
    );

    useEffect(() => {
        navigation.setOptions({
            headerRight: () => (
                <Button
                    onPress={() => navigation.navigate('AddPlant')}
                    title="Ajouter"
                    color="#000"
                />
            ),
        });
    }, [navigation]);

    const deletePlant = (plantId) => {
        Alert.alert(
            "Supprimer la plante",
            "Êtes-vous sûr de vouloir supprimer cette plante ?",
            [
                {
                    text: "Annuler",
                    style: "cancel"
                },
                {
                    text: "Supprimer",
                    onPress: () => {
                        axios.delete(`http://192.168.1.37:9000/api/plants/${plantId}`)
                            .then(() => {
                                setPlants(plants.filter(plant => plant.id !== plantId));
                            })
                            .catch((error) => {
                                console.error(error);
                                Alert.alert("Erreur", "Cette plante est actuellement associée à une garde, elle ne peut donc pas être supprimée.");
                            });
                    }
                }
            ]
        );
    };

    if (!plants.length) {
        return <Text>Loading...</Text>;
    }

    return (
        <ScrollView style={styles.container}>
            <Text style={styles.title}>Liste de mes plantes</Text>
            {plants.map((plant) => (
                <View key={plant.id} style={styles.plantCard}>
                    <View style={styles.cardHeader}>
                        <Text style={styles.plantName}>{plant.name} ({plant.species})</Text>
                        <TouchableOpacity onPress={() => deletePlant(plant.id)}>
                            <AntDesign name="closecircle" size={24} color="red"/>
                        </TouchableOpacity>
                    </View>
                    <Text style={styles.plantCare}>{plant.careInstructions}</Text>
                    {plant.imageBlob && (
                        <Image source={{uri: plant.imageBlob}} style={styles.plantImage}/>
                    )}
                </View>
            ))}
        </ScrollView>
    );
};

const styles = StyleSheet.create({
    container: {
        flex: 1,
        padding: 20,
    },
    title: {
        fontSize: 24,
        fontWeight: 'bold',
        marginBottom: 20,
    },
    plantCard: {
        marginBottom: 20,
        padding: 10,
        borderWidth: 1,
        borderColor: '#ddd',
        borderRadius: 5,
    },
    cardHeader: {
        flexDirection: 'row',
        justifyContent: 'space-between',
        alignItems: 'center',
    },
    plantName: {
        fontSize: 18,
        fontWeight: 'bold',
    },
    plantCare: {
        fontSize: 14,
    },
    plantImage: {
        width: '100%',
        height: 200,
        marginTop: 10,
        borderRadius: 5,
    },
});

export default PlantScreen;
