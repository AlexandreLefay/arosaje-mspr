import * as React from 'react';
import {Button, TextInput} from 'react-native-paper';
import AsyncStorage from '@react-native-async-storage/async-storage';
import {useNavigation} from '@react-navigation/native';
import axios from "axios";
import {Alert} from "react-native";

function LoginScreen() {
    const navigation = useNavigation();
    const [username, setUsername] = React.useState('');
    const [password, setPassword] = React.useState('');

    const navigateToHome = () => {
        navigation.reset({
            index: 0,
            routes: [{name: 'Home'}],
        });
    };

    const handleSubmit = () => {
        axios.post('http://192.168.1.37:9000/api/login', {username, password})
            .then(response => {
                console.log(response.data);
                if (response.data.userId) {
                    AsyncStorage.setItem('CURRENT_USER', JSON.stringify(response.data)).then(() => {
                        navigateToHome();
                    });
                } else {
                    Alert.alert("Erreur", "Nom d'utilisateur ou mot de passe incorrect.");
                }
            })
            .catch(error => {
                console.error(error);
                Alert.alert("Erreur", "Nom d'utilisateur ou mot de passe incorrect.");
            });
    };


    return (
        <>
            <TextInput
                label="Username"
                value={username}
                onChangeText={setUsername}
            />
            <TextInput
                label="Mot de passe"
                value={password}
                secureTextEntry={true}
                onChangeText={setPassword}
            />
            <Button onPress={handleSubmit}>
                Se connecter
            </Button>
        </>
    );
}

export default LoginScreen;
