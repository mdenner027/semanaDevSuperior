export type GamePlatform = 'XBOX' | 'PC' |'PLAYSTATION';

export type Game = {
    idJogo: number;
    tituloJogo:string;
    plataformaJogo: GamePlatform;
    label: string;
    value: number;
    key: string;
}