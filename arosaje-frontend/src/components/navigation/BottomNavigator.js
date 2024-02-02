import * as React from 'react';
import {BottomNavigation} from 'react-native-paper';
import {useNavigation} from "@react-navigation/native";
import GuardianshipScreen from "../../screen/Guardian/GuardianshipScreen";
import HomeScreen from "../../screen/Home/HomeScreen";
import ProfilScreen from "../../screen/Profil/ProfilScreen";
import TicketScreen from "../../screen/Ticket/TicketScreen";
import PlantScreen from "../../screen/Plant/PlantScreen";


const HomeRoute = () => <HomeScreen/>;
const ProfilRoute = () => <ProfilScreen/>;
const TicketRoute = () => <TicketScreen/>;
const PlantRoute = () => <PlantScreen/>;
const GardeRoute = () => <GuardianshipScreen/>;
export default function BottomNavigator() {
    const [index, setIndex] = React.useState(0);
    const navigation = useNavigation(); // Accès à l'objet navigation
    const [routes] = React.useState([
        {key: 'home', title: 'Accueil', focusedIcon: 'heart', unfocusedIcon: 'heart-outline'},
        {key: 'profil', title: 'Profil', focusedIcon: 'account', unfocusedIcon: 'account-outline'},
        {key: 'ticket', title: 'Ticket', focusedIcon: 'ticket', unfocusedIcon: 'ticket-outline'},
        {key: 'plant', title: 'Plant', focusedIcon: 'sprout', unfocusedIcon: 'sprout-outline'},
        {key: 'garde', title: 'Garde', focusedIcon: 'home-circle', unfocusedIcon: 'home-circle-outline'},
    ]);

    React.useEffect(() => {
        const routeTitle = routes[index].title;
        navigation.setParams({title: routeTitle});
    }, [index, navigation]);

    const renderScene = BottomNavigation.SceneMap({
        home: HomeRoute,
        profil: ProfilRoute,
        ticket: TicketRoute,
        plant: PlantRoute,
        garde: GardeRoute,
    });

    return (
        <BottomNavigation
            navigationState={{index, routes}}
            onIndexChange={setIndex}
            renderScene={renderScene}
        />
    );
}
