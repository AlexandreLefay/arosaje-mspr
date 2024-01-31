import {StyleSheet} from "react-native";

export const Style = StyleSheet.create({
  container: {
    padding: 20,
    margin: 20,
  },
  containerView: {
    paddingBottom: 90,
  },
  containerHorizontal:{
    flex: 1,
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'space-around',
    backgroundColor: '#ecf0f1',
    padding: 20,
  },
  containerFlex: {
    padding: 20,
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  input: {
    height: 40,
    marginBottom: 20,
    borderWidth: 1,
    borderColor: 'gray',
    padding: 10,
  },
  button: {
    marginBottom: 20,
    alignItems: 'center',
    backgroundColor: '#DDDDDD',
    padding: 10,
  },
  image: {
    width: '100%',
    height: 200,
    resizeMode: 'contain',
    marginBottom: 20,
  },
  text :{
    fontSize: 14,
    padding: 20
  },
});