import React from 'react';
import { View, Image, Text, StyleSheet } from 'react-native';

const PlantPreview = ({ imageUrl, imageName }) => {
  return (
    <View style={styles.card}>
      <Image source={{ uri: imageUrl }} style={styles.image} />
      <Text style={styles.text}>{imageName}</Text>
    </View>
  );
};

const styles = StyleSheet.create({
  card: {
    shadowColor: '#000', // iOS shadow
    shadowOffset: { width: 0, height: 1 }, // iOS shadow
    shadowOpacity: 0.22, // iOS shadow
    shadowRadius: 2.22, // iOS shadow
    elevation: 3, // Android shadow
    backgroundColor: 'white', // Background color for the card
    borderRadius: 8, // Rounded corners
    overflow: 'hidden', // Keeps the image within the bounds of the border radius
    margin: 10, // Spacing around the card
  },
  image: {
    width: '100%', // Full width of the card
    height: 200, // Fixed height for the image, you can make this dynamic
    resizeMode: 'cover', // Cover the bounds of the image frame
  },
  text: {
    padding: 10, // Padding for the text inside the card
    fontSize: 16, // Font size for the text
    textAlign: 'center', // Center align text
  },
});

export default PlantPreview;