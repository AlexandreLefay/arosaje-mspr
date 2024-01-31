// LoginScreen.js
import React from 'react';
import { View, Text, TextInput, Button } from 'react-native';
import { Formik } from 'formik';
import * as yup from 'yup';
import axios from 'axios';

const LoginPage = () => {
  
    const validationSchema = yup.object().shape({
    username: yup.string().lowercase('Veuillez saisir un identifiant').required('Champ obligatoire'),
    password: yup.string().required('Champ obligatoire'),
  });

  const handleLogin = async (values) => {
    try {

      const response = await axios.post('https://example.com/api/login', {
          headers: {
              'Access-Control-Allow-Origin': 'http://localhost:19006'            
            },
          username: values.username,
          password: values.password,
        }).then(response => {
          alert(response.data)
        })

      
      // Vérifiez si la requête a réussi (statut 2xx)
      if (response.status == 200) {
        const responseData = await response.json();
        alert('Réponse du serveur :', responseData.jwt);
        
      } else {
        alert('Échec de la requête. Statut :', response.status);
      }
    } catch (error) {
      alert('Erreur lors de la requête POST :', error);
    }
  };

return (
    <View>
        <Text>Page de connexion</Text>
        <Formik
        initialValues={{ username: '', password: '' }}

        validationSchema={validationSchema}
        onSubmit={handleLogin}
        >
        {({ handleChange, handleBlur, handleSubmit, values, errors }) => (
            <View>
            <TextInput
                placeholder="Identifiant"
                onChangeText={handleChange('username')}
                onBlur={handleBlur('username')}
                value={values.username}
            />
            <Text style={{ color: 'red' }}>{errors.email}</Text>

            <TextInput
                placeholder="Mot de passe"
                onChangeText={handleChange('password')}
                onBlur={handleBlur('password')}
                value={values.password}
                secureTextEntry
            />
            <Text style={{ color: 'red' }}>{errors.password}</Text>

            <Button onPress={handleSubmit} title="Se connecter" />
            </View>
        )}
        </Formik>
    </View>
    );
};


export default LoginPage;