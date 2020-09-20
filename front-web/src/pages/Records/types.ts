export type RecordsResponse = {
    content: RecordItem[];
    totalPages: number;
}

export type RecordItem = {
    idRecord: number;
    momentoRecord: string;
    nomeJogador: string;
    idadeJogador: number
    tituloJogo: string;
    plataformaJogo: Plataforma;
    generoJogo: string;
}

export type Plataforma = 'XBOX' | 'PC' | 'PLAYSTATION';