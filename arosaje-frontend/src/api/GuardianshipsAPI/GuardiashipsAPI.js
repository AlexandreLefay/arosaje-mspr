import {Button} from "react-native";
import axios from "axios";
import {useNavigation} from "@react-navigation/native";
const apiUrl = "http://localhost:9000/api";
export const PostGuardianships =(props) => {
  const navigation = useNavigation();
  
  const postRequest = () => {
    axios.post(`${apiUrl}/guardianships`,{
      "statusId": props.form.statusId,
      "ownerId": props.form.ownerId,
      "guardianId": props.form.ownerId,
      "plantId": props.form.plantId,
      "title": props.form.title,
      "description": props.form.description,
      "startDate": props.form.startDate,
      "endDate": props.form.startDate
    }).
    then(response => {
      savingPopup(response.data)
      navigation.navigate('Guard', {guard: response.data.id})}).
    catch(error => {console.error('Erreur lors de la requête POST:', error)}
    )}

  const savingPopup = (guard) => {
    alert("La garde "+ guard.title +" a bien été sauvegardée")
    navigation.navigate('Guard', {guardId: guard.id})
  }

  return(
      <Button title={props.title} onPress={postRequest}/>
  )
}

export const getGuardByUserId = async (props) => {
 return  await axios.get(`${apiUrl}/guardianships/user/{ownerUserId}?ownerUserId=${props.userId}`);
}

export const getGuardById = async (props) => {
  return await axios.get(`${apiUrl}/guardianships/{id}?id=${props.guardId}`);
}