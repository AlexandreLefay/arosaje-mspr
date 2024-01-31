import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import HomePage from './src/pages/HomePage';
import UserPage from './src/pages/UserPage';
import AddPlantPage from './src/pages/AddPlantPage';
import PlantPhoto from './src/components/PlantPhoto';
import PlantForm from './src/components/PlantForm';
import LoginPage from './src/pages/LoginPage';
import PlantPreview from './src/components/PlantPreview'; // Assurez-vous que le chemin est correct

const Stack = createNativeStackNavigator();


const  App = () => {
  return (
    <NavigationContainer>
    <Stack.Navigator initialRouteName="Home">
      <Stack.Screen
        name="LoginPage"
        component={LoginPage}
        options={{ title: 'Connexion' }} 
      />
      <Stack.Screen
        name="Home"
        component={HomePage}
        options={{ title: 'Accueil' }} 
      />
      <Stack.Screen
        name="User" 
        component={UserPage}
        options={{ title: 'Utilisateur' }}
      />
      <Stack.Screen
        name="AddPlant" 
        component={AddPlantPage}
        options={{ title: 'Ajouter une plante' }}
      />
      <Stack.Screen
        name="PlantForm" 
        component={PlantForm}
      />
      <Stack.Screen
        name="PlantPhoto" 
        component={PlantPhoto}
      />

      {/* Configurez d'autres écrans ici */}
    </Stack.Navigator>
  </NavigationContainer>
  );
}

export default App;
