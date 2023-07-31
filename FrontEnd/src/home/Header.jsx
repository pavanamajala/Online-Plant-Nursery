import React from 'react'
import logo from '../images/logo.jpg'

const Header = () => {

    return (
        <>
            <div style={{position: 'fixed', top: '0', width: '100%', backgroundColor: 'white'}}>
                <div style={{ display: 'flex', justifyContent: 'center' }}>
                    <a href={'../'} style={{ border: 'none', background: 'none', position: 'absolute', left: '0' }}><img alt='logo' src={logo} style={{ width: '40px', height: '40px', marginLeft: '5px' }}></img></a>
                    <div style={{ fontSize: '30px', fontWeight: 'bold', fontFamily: 'cursive' }}>All Media Download</div>
                </div>
                <div style={{ background: 'black', height: '3px', width: '100%' }}></div>
            </div>
        </>
    )
}

export default Header;
