import React, { useEffect, useState } from 'react'
import axios from "axios";

const ViewSeed = () => {

    const [seeds, setSeeds] = useState([]);
    // let orders = [];


    const getSeeds = async () => {
        const allData = await axios.get('http://localhost:8080/api/seed');
        setSeeds(allData.data)
    }

    useEffect(() => {
        getSeeds();
    }, [])

    console.log(seeds)

    return (
        <div style={{ padding: '50px', width: '80%', }}>
            <table style={{ width: '90%', borderRadius: '5px', boxShadow: '0px 0px 16px #4443403D' }}>
                <thead>
                    <tr>
                        <td>SL.No</td>
                        <td>Name</td>
                        <td>Time</td>
                        <td>Level</td>
                        <td>Temperature</td>
                        <td>Type</td>
                        <td>Watering</td>
                        <td>Description</td>
                        <td>Cost</td>
                    </tr>
                </thead>
                <tbody>
                    {seeds.some((data, index) => {
                        <tr key={index}>
                            <td key={index}>{data?.seedId}</td>
                            <td key={index}>{data?.commonName}</td>
                            <td key={index}>{data?.bloomTime}</td>
                            <td key={index}>{data?.difficultyLevel}</td>
                            <td key={index}>{data?.temperature}</td>
                            <td key={index}>{data?.typeOfSeed}</td>
                            <td key={index}>{data?.watering}</td>
                            <td key={index}>{data?.seedDescription}</td>
                            <td key={index}>{data?.seedsCost}</td>
                        </tr>
                    })}
                </tbody>
            </table>
        </div>
    )
}

export default ViewSeed;
