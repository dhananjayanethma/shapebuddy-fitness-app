import React, {useState} from 'react';
import { Dialog } from 'primereact/dialog';
import '../../Styles/cretateManageWorkout.css'
import axios from 'axios';

const API_HOST = "http://localhost:8080/api";
const INVENTORY_API_URL = `${API_HOST}/posts`;
const Post = () => {
    const [data, setData] = useState([]);
    const [dialogVisible, setDialogVisible] = useState(false);
    const [editingData, setEditingData] = useState(null);

    const fetchInventory = async () => {
        try {
            const response = await axios.get(`${INVENTORY_API_URL}/`+localStorage.getItem("user_id"));
            if (!response.data.success) {
                throw new Error('Network response was not ok');
            }
            setData(response.data.data);
        } catch (error) {
            console.error(error);
        }
    }

    const handleEdit = (data) => {
        setEditingData(data);
        setDialogVisible(true);
    }

    const handleDelete = async (id) => {
        try {
            await axios.delete(`${INVENTORY_API_URL}/${id}`);
            fetchInventory();
        } catch (error) {
            console.error(error);
        }
    };

    const handleSave = async () => {
        try {
            let response;
            if (editingData.id) {
                // If editing an existing product, send a PUT request
                response = await axios.put(`${INVENTORY_API_URL}/${editingData.id}`, editingData, {
                    headers: {
                        'Content-Type': 'application/json',
                    },
                });
            } else {
                // If creating a new product, send a POST request
                response = await axios.post(`${INVENTORY_API_URL}`, editingData, {
                    headers: {
                        'Content-Type': 'application/json',
                    },
                });
            }
            if (!response.data.success) {
                throw new Error('Network response was not ok');
            }
            setDialogVisible(false);
            fetchInventory();
        } catch (error) {
            console.error(error);
        }
    };

    const handleCancel = () => {
        setDialogVisible(false);
    }

    const columns = [
        {field: 'id', header: 'ID'},
        {field: 'title', header: 'Title'},
        {field: 'time', header: 'Product Category'},
        {field: 'description', header: 'Unit Price'},
        {field: 'actions', header: 'Actions'},
    ];

    return (
        <div className="main">
            <table className="table">
                <thead>
                <tr>
                    {columns.map((col, i) => (
                        <th key={col.field}>{col.header}</th>
                    ))}
                </tr>
                </thead>
                <tbody>
                {data.map((post) => (
                    <tr key={post.id}>
                        <td>{post.id}</td>
                        <td>{post.product_name}</td>
                        <td>{post.product_category}</td>
                        <td>{post.unit_price}</td>
                        <td>
                            <button onClick={() => handleEdit(post)}>Edit</button>
                            <button onClick={() => handleDelete(post.id)}>Delete</button>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>
            <Dialog header="Edit Product" visible={dialogVisible} style={{width: '400px'}} onHide={handleCancel}>
                <div>
                    <label htmlFor="product_name">Product Name:</label>
                    <input type="text" id="product_name" value={editingData ? editingData.product_name : ''}
                           onChange={(e) => setEditingData({...editingData, product_name: e.target.value})}/>
                </div>
                <div>
                    <label htmlFor="product_category">Product Category:</label>
                    <input type="text" id="product_category" value={editingData ? editingData.product_category : ''}
                           onChange={(e) => setEditingData({...editingData, product_category: e.target.value})}/>
                </div>
                <div>
                    <label htmlFor="unit_price">Unit Price:</label>
                    <input type="number" id="unit_price" value={editingData ? editingData.unit_price : ''}
                           onChange={(e) => setEditingData({...editingData, unit_price: e.target.value})}/>
                </div>
                <button onClick={handleSave}>Save</button>
                <button onClick={handleCancel}>Cancel</button>
            </Dialog>
        </div>);
}

export default Post;