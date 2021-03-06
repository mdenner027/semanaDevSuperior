import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './styles.css';
import Pagination from './Pagination';
import { RecordsResponse } from './types';
import { formatDate } from './helpers';
import Filters from '../../components/Filters'

const BASE_URL = 'https://sds1-max.herokuapp.com';
const Records = () => {
    const [recordsResponse, setRecordsResponse] = useState<RecordsResponse>();
    const [activePage, setActivePage] = useState(0);
    useEffect(() => {
        axios.get(`${BASE_URL}/records?linesPerPage=12&page=${activePage}`)
            .then(response => setRecordsResponse(response.data));
    }, [activePage]);

    const handlePageChange = (index:number) => {
        setActivePage(index);
    }

    return (
        <div className="page-container">
            <Filters link="/charts" linkText="VER GRÁFICOS"/>
            <table className="records-table" cellPadding="0" cellSpacing="0">
                <thead>
                    <tr>
                        <th id="ins">Instante</th>
                        <th>Nome</th>
                        <th>Idade</th>
                        <th>Plataforma</th>
                        <th>Gênero</th>
                        <th>Título do Game</th>
                    </tr>
                </thead>
                <tbody> 
                    {recordsResponse?.content.map(record => (
                        <tr key={record.idRecord}>
                            <td className="td1">{formatDate(record.momentoRecord)}</td>
                            <td>{record.nomeJogador}</td>
                            <td>{record.idadeJogador}</td>
                            <td>{record.plataformaJogo}</td>
                            <td className="text-secondary">{record.generoJogo}</td>
                            <td className="text-primary">{record.tituloJogo}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
            <Pagination activePage={activePage} 
                totalPages={recordsResponse?.totalPages} goToPage={handlePageChange}/>
        </div>
    );
}

export default Records;