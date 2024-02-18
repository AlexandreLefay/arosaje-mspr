import React, {useCallback, useEffect, useState} from 'react';
import {Alert, Button, ScrollView, StyleSheet, Text, TouchableOpacity, View} from 'react-native';
import axios from "axios";
import {useFocusEffect, useNavigation} from "@react-navigation/native";
import {AntDesign} from '@expo/vector-icons';
import AsyncStorage from '@react-native-async-storage/async-storage';

const TicketScreen = () => {
    const navigation = useNavigation();
    const [tickets, setTickets] = useState([]);

    const fetchTickets = async () => {
        const currentUser = JSON.parse(await AsyncStorage.getItem('CURRENT_USER'));

        axios.get(`http://192.168.1.37:9000/api/tickets/user/${currentUser.userId}`)
            .then((response) => {
                setTickets(response.data);
            })
            .catch((error) => {
                console.log(error);
            });
    };

    useFocusEffect(
        useCallback(() => {
            fetchTickets();
        }, [])
    );

    useEffect(() => {
        navigation.setOptions({
            headerRight: () => (
                <Button
                    onPress={() => navigation.navigate('AddTicket')}
                    title="Ajouter"
                    color="#000"
                />
            ),
        });
    }, [navigation]);

    const deleteTicket = (ticketId) => {
        Alert.alert(
            "Supprimer le ticket",
            "Êtes-vous sûr de vouloir supprimer ce ticket ?",
            [
                {
                    text: "Annuler",
                    style: "cancel"
                },
                {
                    text: "Supprimer",
                    onPress: () => {
                        axios.delete(`http://192.168.1.37:9000/api/tickets/${ticketId}`)
                            .then(() => {
                                setTickets(tickets.filter(ticket => ticket.id !== ticketId));
                            })
                            .catch((error) => {
                                console.error(error);
                                Alert.alert("Erreur", "Impossible de supprimer ce ticket.");
                            });
                    }
                }
            ]
        );
    };

    if (!tickets.length) {
        return <Text>Loading...</Text>;
    }

    return (
        <ScrollView style={styles.container}>
            <Text style={styles.title}>Liste de mes tickets</Text>
            {tickets.map((ticket) => (
                <View key={ticket.id} style={styles.ticketCard}>
                    <View style={styles.cardHeader}>
                        <Text style={styles.ticketName}>{ticket.title}</Text>
                        <TouchableOpacity onPress={() => deleteTicket(ticket.id)}>
                            <AntDesign name="closecircle" size={24} color="red"/>
                        </TouchableOpacity>
                    </View>
                    <Text style={styles.ticketDescription}>{ticket.description}</Text>
                </View>
            ))}
        </ScrollView>
    );
};

const styles = StyleSheet.create({
    container: {
        flex: 1,
        padding: 20,
    },
    title: {
        fontSize: 24,
        fontWeight: 'bold',
        marginBottom: 20,
    },
    ticketCard: {
        marginBottom: 20,
        padding: 10,
        borderWidth: 1,
        borderColor: '#ddd',
        borderRadius: 5,
    },
    cardHeader: {
        flexDirection: 'row',
        justifyContent: 'space-between',
        alignItems: 'center',
    },
    ticketName: {
        fontSize: 18,
        fontWeight: 'bold',
    },
    ticketDescription: {
        fontSize: 14,
    },
});

export default TicketScreen;
