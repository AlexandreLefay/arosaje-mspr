import * as React from 'react';
import { Button } from 'react-native-paper';

const AddPlantButton = ({ onPress }) => (
    <Button icon="plus" mode="contained" onPress={onPress}/>);

export default AddPlantButton;
