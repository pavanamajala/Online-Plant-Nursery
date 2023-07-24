import React from 'react'

const CreateEditSeed = ({inputfields, onInputChange, handleSubmit, input, handleCancel, edit}) => {

    return (
        <div style={{ padding: '30px', width: '24%', borderRadius: '5px', boxShadow: '0px 0px 16px #4443403D', position: 'absolute', left:'33%', top:'10px', backgroundColor:'white'}}>
            {inputfields?.map((data) => (
                <div style={{ padding: '10px' }}>
                    <div style={{ fontWeight: 'bold' }}>{data.label}:</div>
                    <input style={{ width: '300px', padding: '5px', border: '1px solid' }} type={data.type} id={data.id} onChange={onInputChange} value={input[data.id]} />
                </div>
            ))}
            <div style={{width: '300px', display: 'flex', justifyContent: 'space-between'}}>
                <button style={{width: '40%', height:'30px', backgroundColor: '#8bdc81'}} onClick={handleSubmit}>{edit ? "Update" : "Create"}</button>
                <button style={{width: '40%', height:'30px', backgroundColor: 'orange'}} onClick={handleCancel}>Cancel</button>
            </div>
        </div>
    )
}

export default CreateEditSeed;
