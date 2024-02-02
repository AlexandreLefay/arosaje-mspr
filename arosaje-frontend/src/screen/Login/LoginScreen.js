import * as React from 'react';
import {Button, TextInput} from 'react-native-paper';
import {useNavigation} from '@react-navigation/native';

function LoginScreen() {
    const navigation = useNavigation();
    const [email, setEmail] = React.useState('');
    const [password, setPassword] = React.useState('');

    const navigateToHome = () => {
        navigation.reset({
            index: 0,
            routes: [{name: 'Home'}],
        });
    };

    return (
        <>
            <TextInput
                label="Email"
                value={email}
                onChangeText={setEmail}
            />
            <TextInput
                label="Mot de passe"
                value={password}
                secureTextEntry={true}
                onChangeText={setPassword}
            />
            <Button onPress={navigateToHome}>
                Se connecter
            </Button>
        </>
    );
}

export default LoginScreen;
