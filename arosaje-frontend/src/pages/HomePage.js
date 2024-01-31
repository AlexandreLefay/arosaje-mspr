import React, {useEffect, useState} from 'react';
import { View, Text, Button } from 'react-native';
import Navbar from "../components/Navbar";

const HomePage = ({ navigation }) => {

    const [tickets, setTickets] = useState([]);

    const fetchData = async () => {
        try {
            const response = await fetch('http://localhost:9000/api/tickets');
            const data = await response.json();
            console.log(data);
            setTickets(data); // Met à jour l'état tickets avec les données récupérées
        } catch (error) {
            console.log(error);
        }
    };

    useEffect(() => {
        fetchData();
    }, []); // Ajoute un tableau vide comme dépendance pour exécuter une seule fois

  return (
      <View style={{ flex: 1, alignItems: 'center', justifyContent: 'center' }}>
          <Text>Page d'accueil</Text>
          <Navbar navigation={navigation} />
          {tickets.map((ticket, index) => (
              <View key={index} style={{ margin: 10 }}>
                  <Text>Titre: {ticket.title}</Text>
                  <Text>Description: {ticket.description}</Text>
                  <Text>Status: {ticket.status}</Text>
              </View>
          ))}
      </View>
  );
};

export default HomePage;