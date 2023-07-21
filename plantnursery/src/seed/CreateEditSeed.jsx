import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom';
import axios from "axios";
import inputfields from './constant'

const CreateEditSeed = () => {

    const navigate = useNavigate();
    const { seedId } = useParams();
    const [input, setInput] = useState({
        "seedId": 0,
        "commonName": "",
        "bloomTime": "",
        "watering": "",
        "difficultyLevel": "",
        "temperature": "",
        "typeOfSeed": "",
        "seedDescription": "",
        "seedsStock": null,
        "seedsCost": null,
        "seedsPerPacket": null
    });

    const onInputChange = (e) => {
        setInput({ ...input, [e.target.id]: e.target.value })
    }

    const handleSubmit = async () => {
        if (seedId) {
            await axios.put('http://localhost:8080/api/seed', input);
            alert('updated successfully');
            navigate('/seed/view')
        } else {
            await axios.post('http://localhost:8080/api/seed', input);
            alert('created successfully');
            navigate('/seed/view')
        }
    }

    const editSeed = async () => {
        const seeds = await axios.get(`http://localhost:8080/api/seed/${seedId}`);
        setInput(seeds.data);
    }

    useEffect(() => {
        if (seedId) {
            editSeed();
        }
    }, [])

    console.log(input);
    console.log(seedId);
    return (
        <div style={{ padding: '30px', width: '24%', position: 'relative', left: '34%', top: '52px', borderRadius: '5px', boxShadow: '0px 0px 16px #4443403D'  }}>
            {inputfields.map((data) => (
                <div style={{ padding: '10px' }}>
                    <div style={{ fontWeight: 'bold' }}>{data.label}:</div>
                    <input style={{ width: '300px', padding: '5px', border: '1px solid' }} type={data.type} id={data.id} onChange={onInputChange} value={input[data.id]} />
                </div>
            ))}
            <div style={{width: '300px', display: 'flex', justifyContent: 'space-between'}}>
                <button style={{width: '40%', height:'30px', backgroundColor: '#8bdc81'}} onClick={handleSubmit}>{seedId ? "Update" : "Create"}</button>
                <button style={{width: '40%', height:'30px', backgroundColor: 'orange'}} onClick={() => navigate('/seed/view')}>Cancel</button>
            </div>
        </div>
    )
}

export default CreateEditSeed;
