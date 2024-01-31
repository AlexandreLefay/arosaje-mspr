import React, { useState } from 'react';
import { View, TouchableOpacity, StyleSheet, Animated } from 'react-native';
import { Ionicons } from '@expo/vector-icons';
import {useNavigation} from "@react-navigation/native";
import BottomNavigator from '../navigation/BottomNavigator';
import {createNativeStackNavigator} from "@react-navigation/native-stack";
import DropDownPicker from 'react-native-dropdown-picker'
import MyGuardsPage from "../../pages/Guards/MyGuardsPage";
import InProgressGuardPage from "../../pages/Guards/InProgressGuardPage";
import GuardingPage from "../../pages/Guards/GuardingPage";
import AddGuardPage from "../../pages/Guards/AddGuardPage";
import {BottomNavigation} from "react-native-paper";

const MyGuards= () => <MyGuardsPage/>
const InProgressGuardRoute = () => <InProgressGuardPage/>
const GuardingRoute = () => <GuardingPage/>
const AddGuardRoute = () => <AddGuardPage/>

const Stack = createNativeStackNavigator();
const GuardsMenu = () =>{
    const [selectedValue, setSelectedValue] = useState(null);

    const [menuOpen, setMenuOpen] = useState(false);
    const menuWidth = 200;
    const menuHeight = 300;

    const toggleMenu = () => {
        setMenuOpen(!menuOpen);
    };

    const animatedWidth = new Animated.Value(menuOpen ? menuWidth : 0);
    const animatedHeight = new Animated.Value(menuOpen ? menuHeight : 0);

    const selectItem = (value)=>{
      setSelectedValue(value)

  }
  const renderScene = BottomNavigation.SceneMap({
    myGuards: MyGuards,
    inProgressGuard: InProgressGuardRoute,
    guarding: GuardingRoute,
    addGuard: AddGuardRoute,
  });



  return (
      <View>
          <Text>Sélectionnez une option :</Text>
          <DropDownPicker
            items={[
                {name:'Mes gardes', value:'myGuards'},
                {name:"Garder", value:'guarding'},
                {name:"Ajouter", value:'addGuardianships'},
                {name:"Gardes en cours", value:'inProgressGuard'},

            ]}
            defaultValue={selectedValue}
            containerStyle={{height: 40}}
            onChangeItem={item => selectItem(item.value)}
           />
      </View>
    );
}

const stylesMenu = StyleSheet.create({
    container: {
        flexDirection: 'row',
        alignItems: 'center',
        backgroundColor: '#fff',
    },
    toggleButton: {
        padding: 10,
    },
    menu: {
        overflow: 'hidden',
    },
    menuItem: {
        flexDirection: 'row',
        alignItems: 'center',
        padding: 10,
    },
});
export default GuardsMenu

