import React from 'react';
import {  ScrollView } from 'react-native';
import GuardForm from '../../components/guards/GuardForm';
import {Style} from "../../components/Style";
const AddGuardPage = ({ navigation }) => {
  return (
      <ScrollView style={Style.containerView}>
        <GuardForm navigation={navigation} />
      </ScrollView>
  );
};

export default AddGuardPage;