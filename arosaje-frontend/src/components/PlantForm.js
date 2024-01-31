import React, { useState } from 'react';
import { View, TextInput, Button, StyleSheet, Image, TouchableOpacity, Text } from 'react-native';
import * as ImagePicker from 'expo-image-picker';

const PlantForm = ({ navigation }) => {

  const [image, setImage] = useState(null);
  const [formData, setFormData] = useState({
    name: '',
    species: '',
    instructions: '',
    imageUri: null,
  });

const handleInputChange = (inputName, inputValue) => {
  const newFormData = { ...formData, [inputName]: inputValue };
  setFormData(newFormData);
};


  const pickImage = async () => {
    // Demander la permission d'accéder à la galerie de photos
    const permissionResult = await ImagePicker.requestMediaLibraryPermissionsAsync();
    if (permissionResult.granted === false) {
      alert("Vous avez refusé l'autorisation d'accéder à vos photos !");
      return;
    }
    
    // Sélectionner l'image
    const result = await ImagePicker.launchImageLibraryAsync({
      mediaTypes: ImagePicker.MediaTypeOptions.All,
      allowsEditing: true,
      aspect: [4, 3],
      quality: 1,
    });

    console.log(result);


    if (!result.canceled) {
      setImage(result.assets[0].uri);
    }

    // Mise à jour du state avec l'URI de l'image
    handleInputChange('imageUri', result.assets[0].uri);
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

      {/* <TouchableOpacity onPress={pickImage} style={styles.button}>
        <Text>{formData.imageUri ? 'Changer' : 'Ajouter'} la photo</Text>
      </TouchableOpacity> */}
      <View style={{ flex: 1, alignItems: 'center', justifyContent: 'center' }}>
        <Button title="Ajouter une image" onPress={pickImage} />
        {image &&
          <Image 
            source={{ uri: image }} 
            style={{ width: 200, height: 200 }}
          />
        }
      </View>
      <Button title="Prendre une photo" onPress={() => navigation.navigate('PlantPhoto')} />
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