import React from 'react';
import { View, Text, Button } from 'react-native';
import Navbar from "../components/Navbar";


const HomePage = ({ navigation }) => {
  return (
    <View style={{ flex: 1, alignItems: 'center', justifyContent: 'center' }}>
      <Text>Page d'accueil</Text>
      <Navbar navigation={navigation} />
    </View>
  );
};

export default HomePage;