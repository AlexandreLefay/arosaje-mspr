import React, {useEffect, useState} from 'react';
import { Text, View, Platform } from 'react-native';
import {Style} from "../Style";
import moment from "moment";
import DateTimePicker from 'react-native-ui-datepicker';
const MyDatePicker = (props) => {
  const [date, setDate] = useState(new Date())


  const dateChange = (selectedDate) => {
    const currentDate = selectedDate || date
    setDate(currentDate)
    let formatDate= (moment(currentDate.format("YYYY-MM-DD")+ 'T00:00:00.000Z'))
    props.onValueChange(formatDate._i)
  }
  return(
    <View style={Style.container}>
      <View style={Style.container}>
        <DateTimePicker
          mode="single"
          date={date}
          onChange={(params) => dateChange(params.date)}
          minDate={props.min}
          maxDate={props.max}
        />
      </View>
    </View>
  )
}

export default MyDatePicker