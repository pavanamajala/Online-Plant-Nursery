import React from 'react'
import './style.css'
import bg from '../images/background.jpg'

export const ViewSites = () => {
  return (
    <div style={{ display: 'flex', justifyContent: 'center'}}>
        <img src={bg} alt='img' style={{position: 'absolute', top: '63px', opacity: '0.4', height: '90%', width: '100%'}}></img>
        <div style={{textAlign: 'center', fontWeight: 'bold', fontFamily: 'inherit'}}>     
        <div className= "blinking-text">Coming Soon !!!!!!!</div>
           <div style={{marginTop: '50%'}}>
           Thanks for Coming <br/>
            A brand new website is coming here<br/>
            Please wait a little more <br/>
            Wanna know me more? Just click on the links below
           </div>
        </div>
    </div>
  )
}
