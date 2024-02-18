import {Button} from 'react-native-paper';
import axios from "axios";
import {useNavigation} from "@react-navigation/native";
import {apiIp} from "../../utils/config";
import {Style} from "../../components/Style";
export const PostGuardianships =(props) => {
  const navigation = useNavigation();
  
  const postRequest = () => {
    console.log(props)
    axios.post(apiIp+'/guardianships',{
      "statusId": props.form.statusId,
      "ownerId": props.form.ownerId,
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
    <Button style={Style.button} title={props.title} onPress={postRequest}>Ajouter</Button>
  )
}

export const getGuardByUserId = async (props) => {
 return  await axios.get(apiIp+'/guardianships/user/{ownerUserId}?ownerUserId='+props.userId);
}

export const getGuardById = async (props) => {
  return await axios.get(apiIp+'/guardianships/{id}?id='+props.guardId);
}