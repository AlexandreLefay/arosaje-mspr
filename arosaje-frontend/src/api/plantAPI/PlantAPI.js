import axios from "axios";

const apiUrl = "http://localhost:9000/api";


export const getPlants = async () => {
    return await axios.get(`${apiUrl}/plants/user/1`);
}