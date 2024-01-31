import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import HomePage from './src/pages/HomePage';
import UserPage from './src/pages/UserPage';


import PlantPreview from './src/components/PlantPreview'; // Assurez-vous que le chemin est correct

const Stack = createNativeStackNavigator();


const  App = () => {
  return (
    <NavigationContainer>
    <Stack.Navigator initialRouteName="Home">
      <Stack.Screen
        name="Home"
        component={HomePage}
        options={{ title: 'Accueil' }} // Vous pouvez définir les options pour personnaliser la barre de titre
      />
      <Stack.Screen
        name="UserPage" 
        component={UserPage}
        options={{ title: 'Utilisateur' }} />
      {/* Configurez d'autres écrans ici */}
    </Stack.Navigator>
  </NavigationContainer>
  );
}

export default App;

// const styles = StyleSheet.create({
//   container: {
//     flex: 1,
//     backgroundColor: '#fff',
//     alignItems: 'center',
//     justifyContent: 'center',
//   },
// });
