import axios from "axios";
const apiUrl = "http://localhost:9000/api/";

export const geUserById = async (props) => {
  return  await axios.get(`${apiUrl}users/${props.userId}`);
}