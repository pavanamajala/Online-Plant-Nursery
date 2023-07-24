import React from 'react'
import logo from '../images/logo.jpg'

const Header = () => {

    return (
        <>
            <div style={{ display: 'flex', justifyContent: 'space-between' }}>
                <a href={'../'} style={{ border: 'none', background: 'none' }}><img alt='logo' src={logo} style={{ width: '50px', height: '50px' }}></img></a>
                <div style={{fontSize: '34px', fontWeight: 'bold', fontFamily: 'cursive'}}>Online Plant Nursery</div>
                <div style={{fontSize: '14px', fontWeight: 'bold', marginTop: '14px', marginRight: '10px'}}>Logout</div>
            </div>
            <div style={{background:'black', height: '10px', width: '100%'}}></div>
        </>
    )
}

export default Header;
