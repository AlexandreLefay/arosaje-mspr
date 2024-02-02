import * as React from 'react';
import {Provider as PaperProvider} from 'react-native-paper';
import AppNavigator from './src/routes/AppNavigator';
import {SafeAreaProvider} from "react-native-safe-area-context";

export default function App() {
    return (
        <SafeAreaProvider>
            <PaperProvider>
                <AppNavigator/>
            </PaperProvider>
        </SafeAreaProvider>
    );
}
