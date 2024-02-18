import axios from "axios";
import {apiIp} from "../../utils/config";


export const getPlants = async () => {
    return await axios.get(apiIp`/plants/user/1`);
}