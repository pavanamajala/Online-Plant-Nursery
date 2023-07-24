import React, { useEffect, useState } from 'react'
import axios from "axios";
import AddModal from '../sharedcomponents/AddModal'
import inputfields from './constant';

const ViewSeed = () => {

    const [seeds, setSeeds] = useState([]);
    const [addModal, setAddModal] = useState(false);
    const [edit, setEdit] = useState(false);
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

    const getSeeds = async () => {
        const allData = await axios.get('http://localhost:8080/api/seed');
        setSeeds(allData.data)
    }

    const onInputChange = (e) => {
        setInput({ ...input, [e.target.id]: e.target.value })
    }

    const deleteSeed = async (id) => {
        let status = await axios.delete(`http://localhost:8080/api/seed/${id}`)
        console.log(status);
        alert('deleted successfully');
        getSeeds();
    }

    const handleSubmit = async () => {
        if (edit) {
            await axios.put('http://localhost:8080/api/seed', input);
            alert('updated successfully');
        } else {
            await axios.post('http://localhost:8080/api/seed', input);
            alert('created successfully');
        }
        setAddModal(false);
        getSeeds();
    }

    const handleEdit = async (id) => {
        setAddModal(true);
        setEdit(true);
        const seeds = await axios.get(`http://localhost:8080/api/seed/${id}`);
        setInput(seeds.data);
    }

    useEffect(() => {
        getSeeds();
    }, [])

    return (
        <>
            <div style={addModal ? { padding: '30px', filter: 'blur(5px)' } : { padding: '30px' }}>
                <div style={{display: 'flex', justifyContent: 'space-between'}}>
                    <h1>SEEDS</h1>
                <button style={{marginTop: '20px', height: '30px', backgroundColor: '#8bdc81', margin: '25px', float: 'right', width: '120px' }} onClick={() => setAddModal(true)}>Create</button>
                </div>
           
                <table style={{ width: '100%', borderRadius: '5px', boxShadow: '0px 0px 16px #4443403D', padding:'15px' }} >
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
                            <td>Stock</td>
                            <td>Per Packet</td>
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
                                <td >{data?.seedsPerPacket}</td>
                                <td >{data?.seedsStock}</td>
                                <td >{data?.seedsCost}</td>
                                <td><button style={{ backgroundColor: 'orange' }} onClick={() => handleEdit(data?.seedId)}>Edit</button> &nbsp;&nbsp;
                                    <button style={{ backgroundColor: 'red' }} onClick={() => deleteSeed(data?.seedId)}>delete</button>
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
            {addModal && (
                <AddModal
                    inputfields={inputfields}
                    input={input}
                    handleCancel={() => setAddModal(false)}
                    onInputChange={onInputChange}
                    handleSubmit={handleSubmit}
                    edit={edit}
                />
            )}
        </>
    )
}

export default ViewSeed;
