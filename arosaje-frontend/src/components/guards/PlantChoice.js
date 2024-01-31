import React, { useState, useEffect } from 'react';
import {View} from 'react-native';
import {Style} from "../Style";
import { List } from 'react-native-paper';


const PlantChoice =(props) =>{

  const [expanded, setExpanded] = React.useState(false);
  const [plant, setPlant] = useState({name: "Choisir plante"});

  const handlePress = () => setExpanded(!expanded);


  const [plants, setPlants ] = useState([]);
  useEffect(()=> {
    fetchMyPlants();
  }, [])

  // TODO : remplacer le get plants par getPlantsByUserId
  const fetchMyPlants = async () => {
    try {
      const response = await fetch('http://localhost:9000/api/plants');
      const data = await response.json();
      setPlants(data);
    } catch (error) {
    }
  };

  const selectPlant = (chosenPlant) =>{
    setPlant('')
    setPlant(chosenPlant)
    handlePress()
    props.onValueChange(chosenPlant)
  }

  return(
    <View>
      <List.Section
        style={Style.text} title='Sélectionnez la plante à faire garder :'>
        <List.Accordion
          title={plant.name}
          left={props =>
            <List.Icon {...props} icon="flower"
            />}
          expanded={expanded}
          onPress={handlePress}>
            {plants.map((plant) => (
            <List.Item key={plant.id}
                       title={ plant.name}
                       name={{plant}}
                       value={plant.id}
                       onPress={() => selectPlant(plant)}
            />
        ))}
        </List.Accordion>
      </List.Section>
    </View>
  )
}

export default PlantChoice