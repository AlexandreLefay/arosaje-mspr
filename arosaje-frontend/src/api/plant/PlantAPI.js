import axios from "axios";

const apiUrl = "http://192.168.1.37:9000";


export const getPlants = async () => {
    return await axios.get(`${apiUrl}/api/plants/user/1`);
}