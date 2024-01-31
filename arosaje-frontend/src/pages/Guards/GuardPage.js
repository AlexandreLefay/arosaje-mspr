import React, {useEffect, useState} from 'react';
import {Card} from "react-native-paper";
import { ScrollView, Text} from "react-native";
import { useRoute } from '@react-navigation/native';
import FormatDate from "../../components/guards/FormatDate";
import {Style} from "../../components/Style";
import {getGuardById} from "../../api/GuardianshipsAPI/GuardiashipsAPI";
import {getPlantById, getPlants} from "../../api/plantAPI/PlantAPI";
import {geUserById} from "../../api/UserAPI/UserApi";

const GuardPage = (props) =>{
    const route = useRoute();
    const [guard, setGuard] = useState([]);
    const [guardian, setGuardian] = useState([]);
    const [owner, setOwner] = useState([]);
    const [plant, setPlant] = useState([]);

    useEffect(()=>{
        let guardId = props.route.params.guardId ? props.route.params.guardId :1
        getGuardById({guardId:guardId}).then(guardResponse =>{
            setGuard(guardResponse.data)
        })
        geUserById({userId:1}).then(response =>{
            setGuardian(response.data)
        });
        geUserById({userId:1}).then(response =>{
            setOwner(response.data)
        });
// TODO : faire fonctionner la recherche au fur et a mesure du useEffet

        getPlants().then(plantResponse => {
            setPlant(plantResponse.data.find(plant => plant.id === guard.plantId))
        }, [guard, guardian, owner, plant, props]);
    });

    return(
        <ScrollView>
            <Card key={guard.id} style={Style.container} >
                <Text>{guard.title}</Text>
                <Text>Garde n° : {guard.id}</Text>
                <Text>Propriétaire : {owner.username}</Text>
                <Text>Date de début de la garde : <FormatDate date={guard.startDate}/></Text>
                <Text>Date de fin de la garde : <FormatDate date={guard.endDate}/></Text>
                <Text>Gardien : {guardian.username}</Text>
            </Card>
        </ScrollView>
    )
}
export default GuardPage