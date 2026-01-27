import React, {useState, useEffect} from "react";
import '../../Styles/createmypost.css'
import axios from 'axios';

const CreateMyPost = () => {
    const [posts, setPosts] = useState([]);

    useEffect(() => {
        const fetchPosts = async () => {
            try {
                const response = await axios.get('http://localhost:8080/api/posts');
                setPosts(response.data);
            } catch (error) {
                console.error(error);
            }
        };

        fetchPosts();
    }, []);

    return (
        <div className="container">
            {posts.map((post) => (
                <div className="row" key={post.id}>
                    <div className="col">
                        <h3>{post.title}</h3>
                        <p>{post.content}</p>
                    </div>
                </div>
            ))}
        </div>
    );
};

export default CreateMyPost;