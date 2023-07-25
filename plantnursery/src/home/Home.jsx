import { React, useState } from 'react'
import { useNavigate } from 'react-router-dom';
import AddModal from '../sharedcomponents/AddModal'
import inputfields from './constant'
import axios from "axios";

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
    try {
      const res = await axios.post('http://localhost:8080/auth/login', input);
      if (res.data) {
        localStorage.setItem('token', res.data);
        navigate('./seed/view')
      } else {
        localStorage.setItem('token', '');
      }
    } catch {
      alert('api failed')
    }
  }

  return (
    <div>
      {/* <Link to={'/seed/view'}>SEEDS</Link> */}
      <div style={{ position: 'relative', marginTop: '140px' }}>
        <AddModal
          inputfields={inputfields}
          input={input}
          onInputChange={onInputChange}
          handleSubmit={handleSubmit}
        />
      </div>
    </div>
  )
}

export default Home;
