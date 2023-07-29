import React from 'react'

export const Footer = () => {
  return (
      <div style={{ position:'fixed', bottom:'0', width: '100%', backgroundColor: 'black', color: 'white', display: 'flex', height: '25px', textAlign: 'center'}}>
          <div style={{ color: 'white'}}>@author pavan_amajala</div>
          <div style={{position: 'absolute', right: '0', width: '54% ', display: 'flex', justifyContent: 'space-between'}}>
              <a href='https://www.linkedin.com/in/sri-ram-pavan-amajala-a31404192/' target="_blank" style={{color:'#0077B5', textDecoration: 'none'}}>LinkedIn</a>
              <a href='https://www.instagram.com/pavan.in' target="_blank" style={{color:'#E4405F', textDecoration: 'none'}}>Instagram</a>
              <a href='https://www.facebook.com/pavan-amajala' target="_blank" style={{color:'1877F2', textDecoration: 'none'}}>Facebook</a>
          </div>
      </div>
  )
}
