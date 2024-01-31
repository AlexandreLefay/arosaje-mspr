import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View } from 'react-native';
import Navbar from "./src/components/Navbar";

export default function App() {
  return (
    <View style={styles.container}>
      <Text>My react native app!</Text>
      <StatusBar style="auto" />
        <Navbar/>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
