export type Jogo = {
    idJogo: number;
    tituloJogo: string;
    plataformaJogo: Plataforma;
}

export type Plataforma = 'XBOX' | 'PC' | 'PLAYSTATION';

export type ChartItem = {
    x: string;
    y: number;
}