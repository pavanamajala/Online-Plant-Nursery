import React from 'react'
import axios from "axios";
import { useEffect } from 'react';
import { useState } from 'react';

const ViewOrder = () => {

    const [orders, setOrders] = useState([]);

    const allOrders = async () => {
        const allOrders =  await axios.get('http://localhost:8080/api/order');
        setOrders(allOrders.data);
    }

    useEffect(() => {
        allOrders();
    }, [])

    console.log(orders)
    
    return (
        <div>{orders[0].bookingOrderId}
            {/* <div style={{background: 'red'}}>
                {orders.length > 0 && orders?.forEach((data) => {
                    <div style={{background: 'red'}}>{data}</div>
                })}
            </div> */}
        </div>
    )
}

export default ViewOrder;
