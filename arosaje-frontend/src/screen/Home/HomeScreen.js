import * as React from 'react';
import {ScrollView, StyleSheet} from 'react-native';
import {Button, Card, Text} from 'react-native-paper';
import {useNavigation} from '@react-navigation/native';
import HomeImage from './home-image.jpg';


function HomeScreen() {
    const navigation = useNavigation();
    return (
        <ScrollView style={styles.container}>
            <Card style={styles.card}>
                <Card.Cover source={HomeImage}/>
                <Card.Content>
                    <Text style={styles.title}>Bienvenue sur Arosaje!</Text>
                    <Text style={styles.paragraph}>
                        Arosaje est votre application du quotidien pour vous aider à soigner vos plantes.
                    </Text>
                </Card.Content>
            </Card>
            <Card style={styles.card}>
                <Card.Content>
                    <Text style={styles.heading}>Fonctionnalités Clés :</Text>
                    <Text style={styles.bulletPoint}>• Sauvegarde des vos plantes avec la plus belle des photos</Text>
                    <Text style={styles.bulletPoint}>• Création d'un ticket pour demander de l'aide à notre communauté
                        afin de traiter au mieux votre plantes</Text>
                    <Text style={styles.bulletPoint}>• Demande de garde, vous partez en vacances ou vous souhaitez que
                        votre plante se refasse un beauté ? Vous pouvez la laisser en garde chez un de nos botaniste,
                        membre de la communauté</Text>
                </Card.Content>
            </Card>
            <Button mode="contained" style={styles.button} onPress={() => navigation.navigate('AddPlant')}>
                Commencer maintenant
            </Button>
        </ScrollView>
    );
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        padding: 8,
        backgroundColor: '#f5f5f5',
    },
    card: {
        marginBottom: 16,
        elevation: 4,
        shadowOffset: {width: 0, height: 2},
        shadowRadius: 4,
        shadowOpacity: 0.25,
    },
    title: {
        fontSize: 22,
        fontWeight: 'bold',
        marginTop: 12,
        marginBottom: 8,
    },
    paragraph: {
        fontSize: 16,
        lineHeight: 24,
    },
    heading: {
        fontSize: 20,
        fontWeight: 'bold',
        marginBottom: 8,
    },
    bulletPoint: {
        fontSize: 16,
        lineHeight: 24,
    },
    button: {
        backgroundColor: '#42a83e',
        paddingVertical: 8,
        marginHorizontal: 16,
        marginBottom: 16,
    },
});

export default HomeScreen;
