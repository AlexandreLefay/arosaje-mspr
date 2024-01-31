import React from 'react';
import { View, ScrollView } from 'react-native';
import PlantForm from '../components/PlantForm'; // Assurez-vous que le chemin est correct

const AddPlantPage = ({ navigation }) => {
  return (
    <ScrollView>
      <PlantForm navigation={navigation} />
    </ScrollView>
  );
};

export default AddPlantPage;