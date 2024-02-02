import React from 'react';
import { View, Text, Image, StyleSheet, TouchableOpacity } from 'react-native';
import { Ionicons } from '@expo/vector-icons';
import { useNavigation } from '@react-navigation/native';


const Navbar = () => {
    const navigation = useNavigation();

    return (
        <View style={styles.container}>
            {/* Section gauche: Photo de profil */}
            <TouchableOpacity
                style={styles.profileContainer}
                onPress={() => navigation.navigate('User')}
            >
                <Image
                    source={{ uri: 'https://sm.ign.com/t/ign_fr/cover/a/avatar-gen/avatar-generations_bssq.300.jpg' }} // Remplacez par l'URL de votre photo de profil
                    style={styles.profilePic}
                />
            </TouchableOpacity>

            {/* Section centrale: Nom de l'application */}
            <View style={styles.titleContainer}>
                <Text style={styles.title}>Arosaje</Text>
            </View>

            {/* Section droite: Icône de recherche */}
            <TouchableOpacity style={styles.iconContainer}>
                <Ionicons name="ios-search" size={24} color="black" />
            </TouchableOpacity>
        </View>
    );
};

const styles = StyleSheet.create({
    container: {
        flexDirection: 'row',
        justifyContent: 'space-between',
        alignItems: 'center',
        paddingHorizontal: 10,
        height: 90, // Hauteur de la navbar
        backgroundColor: 'white', // Couleur de fond de la navbar
        position: 'absolute', // Positionnement absolu par rapport à son conteneur
        left: 0, // Aligné à gauche
        right: 0, // Aligné à droite
        bottom: 0, // Aligné en bas
        zIndex: 999,
    },
    profileContainer: {
        flex: 1,
        alignItems: 'flex-start',
    },
    profilePic: {
        width: 40, // Ajustez selon votre besoin
        height: 40, // Ajustez selon votre besoin
        borderRadius: 20, // Cela rendra l'image circulaire
    },
    titleContainer: {
        flex: 2,
        alignItems: 'center',
    },
    title: {
        fontSize: 18, // Ajustez selon votre besoin
        fontWeight: 'bold',
    },
    iconContainer: {
        flex: 1,
        alignItems: 'flex-end',
    },
});

export default Navbar;
