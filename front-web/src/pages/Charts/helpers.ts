import { Jogo } from './types';
import { RecordItem } from '../Records/types';

export const buildBarSeries = (jogos: Jogo[], records: RecordItem[]) => {
  const mappedGames = jogos.map(jogo => {
    const filteredGames = records.filter(item => {
      return item.tituloJogo === jogo.tituloJogo && item.plataformaJogo === jogo.plataformaJogo
    });

    return {
      x: `${jogo.tituloJogo} | ${jogo.plataformaJogo}`,
      y: filteredGames.length
    }
    
  });

  const sortedGames = mappedGames.sort((a, b) => {
    return b.y - a.y;
  });

  return sortedGames.slice(0, 8);
};

export const getPlatformChartData = (records: RecordItem[]) => {
  const platforms = ["PC", "PLAYSTATION", "XBOX"];

  const series = platforms.map(platform => {
    const filtedGames = records.filter(item => {
      return platform === item.plataformaJogo;
    })

    return filtedGames.length;
  });

  return {
    labels: platforms,
    series,
  };
};

export const getGenderChartData = (records: RecordItem[]) => {
   const genderByAmount = records.reduce((accumulator, currentValue) => {
     if (accumulator[currentValue.generoJogo] !== undefined) {
       accumulator[currentValue.generoJogo] += 1;
     } else {
      accumulator[currentValue.generoJogo] = 1;
     }

     return accumulator;
   }, {} as Record<string, number>);

   const labels = Object.keys(genderByAmount);
   const series = Object.values(genderByAmount);

  return {
    labels,
    series
  };
};