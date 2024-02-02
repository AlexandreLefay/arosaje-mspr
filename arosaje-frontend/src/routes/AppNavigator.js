import * as React from 'react';
import {NavigationContainer} from '@react-navigation/native';
import {createNativeStackNavigator} from '@react-navigation/native-stack';
import LoginScreen from '../screen/Login/LoginScreen';
import BottomNavigator from '../components/navigation/BottomNavigator';

const Stack = createNativeStackNavigator();

function AppNavigator() {
    const [headerTitle, setHeaderTitle] = React.useState("Home");

    return (
        <NavigationContainer>
            <Stack.Navigator>
                <Stack.Screen name="Login" component={LoginScreen}/>
                <Stack.Screen
                    name="Home"
                    component={BottomNavigator}
                    options={({route}) => ({
                        title: route.params?.title || 'Titre par Défaut',
                    })}
                />
                <Stack.Screen name="Profil" component={BottomNavigator}/>
                <Stack.Screen name="Ticket" component={BottomNavigator}/>
                <Stack.Screen name="Plant"  component={BottomNavigator}/>
                <Stack.Screen name="Garde" component={BottomNavigator}/>
            </Stack.Navigator>
        </NavigationContainer>
    );
}

export default AppNavigator;
