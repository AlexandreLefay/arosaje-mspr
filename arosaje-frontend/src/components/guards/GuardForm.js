import React, { useState } from 'react';
import {View, Button, ScrollView} from 'react-native';
import MyDatePicker from './MyDatePicker';
import {Style} from "../Style";
import { TextInput } from 'react-native-paper';
import PlantChoice from "./PlantChoice";
import {PostGuardianships} from "../../api/GuardianshipsAPI/GuardiashipsAPI";

const GuardForm = (navigation) => {
  

  const [formData, setFormData] = useState({
    ownerId: 1,
    guardianId: 1,
    title: '',
    plantId: '',
    description: '',
    startDate: '',
    endDate: '',
    statusIs: 0,
    navigation: navigation,
  });

  const handleInputChange = (inputName, inputValue) => {
    const newFormData = { ...formData, [inputName]: inputValue };
    setFormData(newFormData);
  };
  const changeStartDate = (date) => {
    handleInputChange('startDate', date)
  }
  const changeEndDate = (date) =>{
    handleInputChange('endDate', date)
  }
  const selectPlant = (plant) =>{
    handleInputChange('plantId', plant.id)
  }

  const popup = () => {
    alert('Toutes les champs doivent être renseignés')
  };

  return (
    <ScrollView style={Style.containerView}
                keyboardShouldPersistTaps="handled">
      <TextInput label={"Nom de la garde :"}
      value={formData.title}
      onChangeText={(text) => handleInputChange('title', text)}
      style={Style.input}
      />

      <PlantChoice onValueChange={selectPlant}/>

      <TextInput label={"Description de la garde :"}
                 value={formData.description}
                 onChangeText={(text) => handleInputChange('description', text)}
                 style={Style.input}
      />

      <View style={Style.containerHorizontal}>
        <MyDatePicker label='Date de début de garde' onValueChange={changeStartDate}/>
        <MyDatePicker label='Date de fin de garde' onValueChange={changeEndDate}/>
      </View>
      { (formData.title !== '' && formData.endDate !== '' && formData.startDate !== ''
        && formData.description !== '' && formData.plantId !== '') ?
          <PostGuardianships title="Ajouter" form={formData} /> :
          <Button title='Ajouter' onPress={popup}/>
      }

    </ScrollView>
  )
};

export default GuardForm