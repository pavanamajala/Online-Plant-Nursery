import React from 'react'
import './YoutubeVideo.scss'

export const YoutubeVideo = () => {
  return (
    <div className='main-container'>
        <div  className='parent-div'>
            <div  className='input-btn'>
                <input placeholder='Paste your link' />
                <button>Download</button>
            </div>
        </div>
    </div>
  )
}
