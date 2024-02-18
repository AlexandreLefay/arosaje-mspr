import React, {useState} from 'react';
import {Alert, Button, StyleSheet, TextInput, View} from 'react-native';
import axios from 'axios';

/**
 * Écran d'ajout de plante, redirige vers l'écran de prise de photo.
 * Je n'ai pas séparé les composants pour des raisons de simplicité.
 * TODO: Séparer les composants, revoir la structure et la logique.
 */
const AddPlantScreen = ({navigation}) => {
    const [plant, setPlant] = useState({
        name: '',
        species: '',
        careInstructions: '',
        userId: 1,
    });
    const handleSubmit = () => {
        axios.post('http://192.168.1.37:9000/api/plants', plant)
            .then(response => {
                Alert.alert("Succès", "Plante ajoutée avec succès, prenez la en photo !");
                navigation.navigate('TakePhoto', {plantId: response.data.id, userId: response.data.userId});
            })
            .catch(error => {
                console.error(error);
                Alert.alert("Erreur", "Un problème est survenu lors de l'ajout de la plante.");
            });
    };

    return (
        <View style={styles.container}>
            <TextInput
                placeholder="Nom de la plante"
                value={plant.name}
                onChangeText={(text) => setPlant({...plant, name: text})}
                style={styles.input}
            />
            <TextInput
                placeholder="Espèce"
                value={plant.species}
                onChangeText={(text) => setPlant({...plant, species: text})}
                style={styles.input}
            />
            <TextInput
                placeholder="Instructions de soin"
                value={plant.careInstructions}
                onChangeText={(text) => setPlant({...plant, careInstructions: text})}
                style={styles.input}
            />
            <Button title="Ajouter la plante" onPress={handleSubmit}/>
        </View>
    );
};

const styles = StyleSheet.create({
    container: {
        flex: 1,
        padding: 20,
    },
    input: {
        height: 40,
        marginBottom: 12,
        borderWidth: 1,
        padding: 10,
        borderRadius: 5,
    },
});

export default AddPlantScreen;
