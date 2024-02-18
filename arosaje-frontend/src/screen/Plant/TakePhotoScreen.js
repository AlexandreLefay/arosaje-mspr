import React, {useEffect, useState} from 'react';
import {Button, StyleSheet, Text, View} from 'react-native';
import {Camera} from 'expo-camera';
import axios from "axios";

const TakePhotoScreen = ({navigation, route}) => {
    const [hasPermission, setHasPermission] = useState(null);
    const [camera, setCameraRef] = useState(null);

    useEffect(() => {
        (async () => {
            const {status} = await Camera.requestCameraPermissionsAsync();
            setHasPermission(status === 'granted');
        })();
    }, []);

    const takePicture = async () => {
        if (camera) {
            let photo = await camera.takePictureAsync();
            let localUri = photo.uri;
            let filename = localUri.split('/').pop();

            let match = /\.(\w+)$/.exec(filename);
            let type = match ? `image/${match[1]}` : `image`;

            let formData = new FormData();
            formData.append('file', {uri: localUri, name: filename, type});
            formData.append('userId', route.params.userId);
            formData.append('plantId', route.params.plantId);
            console.log(formData);
            try {
                await axios.post('http://192.168.1.37:9000/api/photos/upload', formData, {
                    headers: {
                        'Accept': 'application/json',
                    },
                });
                navigation.navigate('AddPlant');
            } catch (error) {
                console.error(error);
            }
        }
    };

    if (hasPermission === null) {
        return <View/>;
    }
    if (hasPermission === false) {
        return <Text>No access to camera</Text>;
    }
    return (
        <View style={styles.container}>
            <Camera style={styles.camera} ref={ref => setCameraRef(ref)}>
                <View style={styles.buttonContainer}>
                    <Button title="Take Photo" onPress={takePicture}/>
                </View>
            </Camera>
        </View>
    );
};

const styles = StyleSheet.create({
    container: {
        flex: 1,
    },
    camera: {
        flex: 1,
    },
    buttonContainer: {
        flex: 1,
        backgroundColor: 'transparent',
        flexDirection: 'row',
        margin: 20,
    },
});

export default TakePhotoScreen;
