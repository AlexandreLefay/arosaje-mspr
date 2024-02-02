import React, {useEffect, useState} from 'react';
import {Button, Text, View} from 'react-native';
import {Camera} from 'expo-camera';

function PhotoScreen() {
    const [hasPermission, setHasPermission] = useState(null);
    const [cameraRef, setCameraRef] = useState(null);

    useEffect(() => {
        (async () => {
            const {status} = await Camera.requestCameraPermissionsAsync();
            setHasPermission(status === 'granted');
        })();
    }, []);

    if (hasPermission === null) {
        return <View/>;
    }
    if (hasPermission === false) {
        return <Text>Pas d'accès à la caméra</Text>;
    }

    const takePicture = async () => {
        if (cameraRef) {
            let photo = await cameraRef.takePictureAsync();
            console.log(photo.uri);
            // Conversion de l'image en Blob
            const response = await fetch(photo.uri);
            const blob = await response.blob();
            console.log(blob);
        }
    };


    return (
        <View style={{flex: 1}}>
            <Camera style={{flex: 1}} ref={ref => setCameraRef(ref)}>
                <View
                    style={{
                        flex: 1,
                        backgroundColor: 'transparent',
                        flexDirection: 'row',
                    }}>
                    <Button title={"Prendre une photo"} onPress={takePicture}/>
                </View>
            </Camera>
        </View>
    );
}

export default PhotoScreen;
