import React, {useState, useEffect} from "react";
import logo from './logo.svg';
import './App.css';
import axios from "axios";


function App() {
    const [folders, setFolders] = useState([]);

    useEffect(() => {
        axios.get("http://localhost:8069/user/1/folder").then(res => {
            console.log(res);
            setFolders(res.data);
        });
    }, []);

    return (
        <div className='App'>
            <div className='container'>
                <h1>Hello user!</h1>
            </div>
            <div className='folder-container'>
                <ul>
                    <h2 className='list-head'>Folders</h2>
                    {folders.map((folder) => {
                        return (
                            <li key={folder.id} className='list'>
                                <span className='folder-name'>{folder.name} </span>
                            </li>
                        );
                    })}
                </ul>
            </div>
        </div>
    );
}
export default App;

