import axios from "axios";
import {apiIp} from "../../utils/config";


export const getUserPlants = async (props) => {
    return await axios.get(apiIp+'/plants/user/'+props.user);
}
export const getPlantById = async (props) => {
    return await axios.get(apiIp+'/plants/'+props.plantId);
}