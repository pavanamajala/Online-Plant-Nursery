import React, { useEffect, useState } from 'react'
import { useNavigate, Link } from 'react-router-dom';
import axios from "axios";

const ViewSeed = () => {

    const navigate = useNavigate();
    const [seeds, setSeeds] = useState([]);

    const getSeeds = async () => {
        const allData = await axios.get('http://localhost:8080/api/seed');
        setSeeds(allData.data)
    }

    const deleteSeed = async (id) => {
        let status = await axios.delete(`http://localhost:8080/api/seed/${id}`)
        console.log(status);
        alert('deleted successfully');
        getSeeds();
    }

    useEffect(() => {
        getSeeds();
    }, [])

    return (
        <div style={{ padding: '50px'}}>
            <table style={{ width: '100%', borderRadius: '5px', boxShadow: '0px 0px 16px #4443403D' }}>
                <thead>
                    <tr style={{ fontWeight: 'bold' }}>
                        <td>SL.No</td>
                        <td>Name</td>
                        <td>Time</td>
                        <td>Level</td>
                        <td>Temperature</td>
                        <td>Type</td>
                        <td>Watering</td>
                        <td>Description</td>
                        <td>Cost</td>
                        <td>Actions</td>
                    </tr>
                </thead>
                <tbody>
                    {seeds.map((data, index) => (
                        <tr key={index}>
                            <td >{index + 1}</td>
                            <td >{data?.commonName}</td>
                            <td >{data?.bloomTime}</td>
                            <td >{data?.difficultyLevel}</td>
                            <td >{data?.temperature}</td>
                            <td >{data?.typeOfSeed}</td>
                            <td >{data?.watering}</td>
                            <td >{data?.seedDescription}</td>
                            <td >{data?.seedsCost}</td>
                            <td><Link to={`/seed/edit/${data?.seedId}`} >Edit</Link>&nbsp;&nbsp;
                                <button style={{ backgroundColor: 'red' }} onClick={() => deleteSeed(data?.seedId)}>delete</button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
            <button style={{width: '40%', marginLeft: '25%', marginTop: '20px', height:'30px', backgroundColor: '#8bdc81'}} onClick={() => navigate('/seed/create')}>Create</button>
        </div>
    )
}

export default ViewSeed;
