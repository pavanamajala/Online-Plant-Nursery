import { React, useState } from 'react'
import { useNavigate } from 'react-router-dom';
import AddModal from '../sharedcomponents/AddModal'
import inputfields from './constant'
import axios from "axios";
import { ViewSites } from '../view/ViewSites';

const Home = () => {

  const navigate = useNavigate();

  const [input, setInput] = useState({
    username: 'pavan',
    password: '1234'
  })

  const onInputChange = (e) => {
    setInput({ ...input, [e.target.id]: e.target.value })
  }

  const handleSubmit = async () => {
    if(input.username === 'pavan' && input.password === '1234'){
      alert('Welcome !!!!!')
      navigate('/youtube/download')
    } else {
      alert('bad credentials')
    }
  }

  return (
    <div>
      {/* <Link to={'/seed/view'}>SEEDS</Link> */}
      <div style={{ position: "relative", marginTop: "140px", display: 'flex', justifyContent: 'center' }}>
        <div
          style={{
            padding: "30px",
            width: "50%",
            borderRadius: "5px",
            boxShadow: "0px 0px 16px #4443403D",
            position: "absolute",
            top: "80px",
            backgroundColor: "white",
            maxWidth: '300px'
          }}
        >
          <div
            style={{
              fontWeight: "bold",
              textAlign: "center",
              textDecoration: "underline",
            }}
          >
            {"Welcome"}
          </div>
          {inputfields?.map((data, index) => (
            <div style={{ padding: "10px" }} key={index}>
              <div style={{ fontWeight: "bold" }} key={index}>
                {data.label}:
              </div>
              <input
                style={{ width: "95%", padding: "5px", border: "1px solid" }}
                type={data.type}
                id={data.id}
                onChange={onInputChange}
                value={input[data.id]}
              />
            </div>
          ))}
          <div>
            <button
              style={{
                width: "50%",
                height: "30px",
                backgroundColor: "#8bdc81",
                position: "relative",
                left: "25%",
                marginTop: "20px",
              }}
              onClick={handleSubmit}
            >
              {"Login"}
            </button>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Home;
