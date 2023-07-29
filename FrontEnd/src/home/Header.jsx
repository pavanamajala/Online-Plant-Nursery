import React from 'react'
import logo from '../images/logo.jpg'

const Header = () => {

    return (
        <>
            <div style={{position: 'fixed', top: '0', width: '100%', backgroundColor: 'white'}}>
                <div style={{ display: 'flex', justifyContent: 'space-between' }}>
                    <a href={'../'} style={{ border: 'none', background: 'none' }}><img alt='logo' src={logo} style={{ width: '50px', height: '50px' }}></img></a>
                    <div style={{ fontSize: '34px', fontWeight: 'bold', fontFamily: 'cursive' }}>Pavan's Site</div>
                    <div style={{ fontSize: '14px', fontWeight: 'bold', marginTop: '14px', marginRight: '10px' }}><a href={'../'} style={{ textDecoration: 'none', color: 'black' }}>Logout</a></div>
                </div>
                <div style={{ background: 'black', height: '10px', width: '100%' }}></div>
            </div>
        </>
    )
}

export default Header;
