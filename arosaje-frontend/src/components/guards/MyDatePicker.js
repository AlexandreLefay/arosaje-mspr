import React, { useState } from 'react';
import { Text, View, Platform } from 'react-native';
import {Style} from "../Style";
import moment from "moment";

const MyDatePicker = (props) => {
  const [date, setDate] = useState(new Date())

  const dateChange = (event, selectedDate) => {
    const currentDate = selectedDate || date
    setDate(currentDate)
    let formatDate= (moment(date.toLocaleDateString()).format("YYYY-MM-DD")+ 'T00:00:00.000Z').replaceAll("/", "-", )
    props.onValueChange(formatDate)
  }
  return(
    <View style={Style.container}>
      <Text> {props.label} </Text>

    {Platform.OS === 'web' ? (
        <input type={"date"}
               onChange={dateChange}/>):
      (
        <Text style={Style.text} onChange={dateChange}>
          {`${('0' + date.getDate()).slice(-2)}/${('0' + date.getMonth()).slice(-2)}/${date.getFullYear()}`}
        </Text>
      )
    }
    </View>
  )
}

export default MyDatePicker