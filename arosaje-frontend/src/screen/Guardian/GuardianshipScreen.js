import * as React from 'react';
import {Card, Avatar, IconButton} from 'react-native-paper';
import {TouchableOpacity, View} from "react-native";
import { useNavigation } from '@react-navigation/native';
import {Style} from "../../components/Style";

function GuardScreen({}) {
  const navigation = useNavigation();

    return (
      <View style={Style.container}>
        <TouchableOpacity onPress={() => navigation.navigate('MyGuards', {navigation})}  title='MyGardsPage'>
            <Card.Title
              title="Mes gardes"
              subtitle="Consulter l'ensemble des gardes que j'ai posé"
              left={(props) => <Avatar.Icon {...props} icon="folder" />}
              right={(props) => <IconButton {...props} icon="dots-vertical" onPress={() => navigation.navigate('MyGuards')} />}
              />
        </TouchableOpacity>
        <TouchableOpacity onPress={() => navigation.navigate('Guarding')}  title='GuardinPage'>
          <Card.Title
            title="Consulter mes gardes en cours"
            subtitle="Consulter l'ensemble des gardes que je suis en train d'effectuer ou qui me sont faites"
            left={(props) => <Avatar.Icon {...props} icon="folder" />}
            right={(props) => <IconButton {...props} icon="dots-vertical" onPress={() => navigation.navigate('Guarding')} />}
          />
        </TouchableOpacity>
        <TouchableOpacity onPress={() => navigation.navigate('AllGuards')}  title='AllGuardsPage'>
          <Card.Title
            title="Consulter les demandes de gardes "
            subtitle="Consulter les gardes de la communautée recherchant encore un gardien"
            left={(props) => <Avatar.Icon {...props} icon="folder" />}
            right={(props) => <IconButton {...props} icon="dots-vertical" onPress={() => navigation.navigate('AllGuards')} />}
          />
        </TouchableOpacity>
        <TouchableOpacity onPress={() => navigation.navigate('AddGuard')}  title='MyGardsPage'>
          <Card.Title
            title="Ajouter une garde"
            subtitle="Ajouter une nouvelle demande de garde"
            left={(props) => <Avatar.Icon {...props} icon="folder" />}
            right={(props) => <IconButton {...props} icon="dots-vertical" onPress={() => navigation.navigate('AddGuard')} />}
          />
        </TouchableOpacity>
      </View>
    );
}

export default GuardScreen;
