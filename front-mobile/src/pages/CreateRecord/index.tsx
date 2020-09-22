import React, { useEffect, useState } from 'react';
import { Alert, StyleSheet, Text, View } from 'react-native';
import { RectButton, TextInput } from 'react-native-gesture-handler';
import Header from '../../components/Header';
import PlatformCard from './PlatformCard';
import { Game, GamePlatform } from './types';
import RNPickerSelect from 'react-native-picker-select';
import { FontAwesome5 as Icon } from '@expo/vector-icons'
import Axios from 'axios';

const BASE_URL = "http://192.168.1.5:8080"

const CreateRecord = () => {

    const [name, setName] = useState('');
    const [age, setAge] = useState('');
    const [filteredGames, setFilteredGames] = useState<Game[]>([]);
    const [allGames, setAllGames] = useState<Game[]>([]);
    const [selectedGame, setSelectedGame] = useState('');
    const placehoder = {
        label: "Selecione o Jogo",
        value: null
    }

    const [platform, setPlatform] = useState<GamePlatform>();
    const mapSelect = (games: Game[]) => {
        return games.map(game => ({
            ...game,
            label: game.tituloJogo,
            value: game.idJogo
        }))
    }
    const handleChangePlatform = (selectedPlatform: GamePlatform) => {
        setPlatform(selectedPlatform);
        const gamesByPlatform = allGames.filter(
            game => game.plataformaJogo === selectedPlatform
        );
        setFilteredGames(gamesByPlatform);
    }

    const handleSubmit = () => {
        const payload = {
            idJogo: selectedGame,
            nomeRecord: name,
            idadeRecord: age
        }
        Axios.post(`${BASE_URL}/records`, payload)
            .then(() => {
                Alert.alert("Dados salvos com sucesso");
                setName('');
                setAge('');
                setSelectedGame('');
                setPlatform(undefined);
            }).catch(() => {
                Alert.alert(`Ops! Ocorreu um erro durante a operação.`);
            });
    }



    useEffect(() => {
        Axios.get(BASE_URL + '/jogos').then(response => {
            const selectValues = mapSelect(response.data);
            setAllGames(selectValues);
        });
    }, []);

    return (
        <>
            <Header />
            <View style={styles.container}>
                <TextInput style={styles.inputText}
                    placeholder="Nome"
                    placeholderTextColor="#9E9E9E"
                    onChangeText={setName}
                    value={name}
                />
                <TextInput style={styles.inputText}
                    placeholder="Idade"
                    placeholderTextColor="#9E9E9E"
                    keyboardAppearance="dark"
                    keyboardType="number-pad"
                    maxLength={3}
                    onChangeText={setAge}
                    value={age}
                />
                <View style={styles.platformContainer}>
                    <PlatformCard
                        activePlatform={platform}
                        onChange={handleChangePlatform}
                        icon="desktop"
                        platform="PC" />
                    <PlatformCard
                        activePlatform={platform}
                        onChange={handleChangePlatform}
                        icon="xbox"
                        platform="XBOX" />
                    <PlatformCard
                        activePlatform={platform}
                        onChange={handleChangePlatform}
                        icon="playstation"
                        platform="PLAYSTATION" />
                </View>
            </View>
            <RNPickerSelect
                placeholder={placehoder}
                items={filteredGames}
                value={selectedGame}
                onValueChange={(value) => setSelectedGame(value)}
                style={pickerSelectStyles}
                useNativeAndroidPickerStyle={false}
                Icon={() => {
                    return (
                        <Icon size={25} color="#9e9e9e" name="chevron-down" />
                    );
                }}
            />
            <View style={styles.footer}>
                <RectButton onPress={handleSubmit} style={styles.button}>
                    <Text style={styles.buttonText}>Salvar</Text>
                </RectButton>
            </View>
        </>
    );
}

const pickerSelectStyles = StyleSheet.create({
    inputIOS: {
        fontSize: 16,
        paddingVertical: 12,
        paddingHorizontal: 20,
        backgroundColor: '#FFF',
        borderRadius: 10,
        color: '#ED7947',
        paddingRight: 30,
        fontFamily: "Play_700Bold",
        height: 50
    },
    inputAndroid: {
        fontSize: 16,
        paddingVertical: 12,
        paddingHorizontal: 20,
        backgroundColor: '#FFF',
        borderRadius: 10,
        color: '#ED7947',
        paddingRight: 30,
        fontFamily: "Play_700Bold",
        height: 50
    },
    placeholder: {
        color: '#9E9E9E',
        fontSize: 16,
        fontFamily: "Play_700Bold",
    },
    iconContainer: {
        top: 10,
        right: 12,
    }
});

const styles = StyleSheet.create({
    container: {
        marginTop: '15%',
        paddingRight: '5%',
        paddingLeft: '5%',
        paddingBottom: 50
    },
    inputText: {
        height: 50,
        backgroundColor: '#FFF',
        borderRadius: 10,
        color: '#ED7947',
        fontFamily: "Play_700Bold",
        fontSize: 16,
        paddingLeft: 20,
        marginBottom: 21
    },
    platformContainer: {
        marginBottom: 20,
        flexDirection: 'row',
        justifyContent: 'space-between',
    },
    footer: {
        marginTop: '15%',
        alignItems: 'center',
    },
    button: {
        backgroundColor: '#00D4FF',
        flexDirection: 'row',
        borderRadius: 10,
        height: 60,
        width: '100%',
        alignItems: 'center',
        justifyContent: 'center'
    },
    buttonText: {
        fontFamily: "Play_700Bold",
        fontWeight: 'bold',
        fontSize: 18,
        color: '#0B1F34',
    }
});
export default CreateRecord;