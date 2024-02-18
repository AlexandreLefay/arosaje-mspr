import axios from "axios";
import {apiIp} from "../../utils/config";

export const geUserById = async (props) => {
  return  await axios.get(apiIp`users/${props.userId}`);
}