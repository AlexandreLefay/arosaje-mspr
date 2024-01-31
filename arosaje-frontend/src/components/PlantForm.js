import React, { useState } from 'react';
import { View, TextInput, Button, StyleSheet, Image, TouchableOpacity, Text } from 'react-native';
import * as ImagePicker from 'expo-image-picker';

const PlantForm = ({ navigation }) => {
  const [formData, setFormData] = useState({
    name: '',
    species: '',
    instructions: '',
    imageUri: null,
  });

  const handleInputChange = (inputName, inputValue) => {
    setFormData({ ...formData, [inputName]: inputValue });
  };

  const pickImage = async () => {
    // Demander la permission d'accéder à la galerie de photos
    const permissionResult = await ImagePicker.requestMediaLibraryPermissionsAsync();
    if (permissionResult.granted === false) {
      alert("Vous avez refusé l'autorisation d'accéder à vos photos !");
      return;
    }
    
    // Sélectionner l'image
    const pickerResult = await ImagePicker.launchImageLibraryAsync();
    if (pickerResult.cancelled === true) {
      return;
    }

    // Mise à jour du state avec l'URI de l'image
    handleInputChange('imageUri', pickerResult.uri);
  };

  const handleSubmit = () => {
    console.log('Form Data:', formData);
    // Ici, vous pouvez envoyer les données à un serveur ou les traiter comme nécessaire
  };

  return (
    <View style={styles.container}>
      <TextInput
        placeholder="Nom"
        value={formData.name}
        onChangeText={(text) => handleInputChange('name', text)}
        style={styles.input}
      />
      <TextInput
        placeholder="Espèce"
        value={formData.species}
        onChangeText={(text) => handleInputChange('species', text)}
        style={styles.input}
      />
      <TextInput
        placeholder="Instructions"
        value={formData.instructions}
        onChangeText={(text) => handleInputChange('instructions', text)}
        style={styles.input}
        multiline
      />

      <TouchableOpacity onPress={pickImage} style={styles.button}>
        <Text>{formData.imageUri ? 'Changer' : 'Ajouter'} la photo</Text>
      </TouchableOpacity>
      <TouchableOpacity onPress={pickImage} style={styles.button}>
        <Button title="Prendre une photo" onPress={() => navigation.navigate('PlantPhoto')} />
      </TouchableOpacity>
      {formData.imageUri && (
        <Image source={{ uri: formData.imageUri }} style={styles.image} />
      )}
      <Button title="Ajouter" onPress={handleSubmit} />
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    padding: 20,
  },
  input: {
    height: 40,
    marginBottom: 20,
    borderWidth: 1,
    borderColor: 'gray',
    padding: 10,
  },
  button: {
    marginBottom: 20,
    alignItems: 'center',
    backgroundColor: '#DDDDDD',
    padding: 10,
  },
  image: {
    width: '100%',
    height: 200,
    resizeMode: 'contain',
    marginBottom: 20,
  },
});

export default PlantForm;