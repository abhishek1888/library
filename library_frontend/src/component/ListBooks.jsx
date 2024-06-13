import React, { useState,useEffect } from 'react'
import axios from 'axios'
import {Link} from 'react-router-dom'
export const ListBooks=()=>{
    const [booklist,setBooklist]=useState([]);
    

    const listbooks=async ()=>{
          const result= await axios.get("http://localhost:8080/api/books/getAllbooks");
          setBooklist(result.data);
    }

    const deletebook= async (isbn)=>
        {
            const result= await axios.delete(`http://localhost:8080/api/books/deletebook?iSBN=`+isbn);
            listbooks();
        }
    useEffect(()=>{
        listbooks();
    },[])
    return(
      <div className="table table-bordered">
        <Link to="/add">
              <div class="btn btn-success">Add</div>
        </Link>
        <thead>
            <tr>
            <th>ISBN</th>
            <th>title</th>
            <th>author</th>
            <th>genre</th>
            <th>publicationYear</th>
            <th>publisher</th>
            <th>totalcopies</th>
            <th>Update</th>
            <th>delete</th>
            </tr>
        </thead>
        <tbody>
                {
                    booklist.map(book=>(
                       <tr>
                        <td>{book.isbn}</td>
                         <td>{book.title}</td>
                         <td>{book.author}</td>
                         <td>{book.genre}</td>
                         <td>{book.publicationYear}</td>
                         <td>{book.publisher}</td>
                         <td>{book.totalcopies}</td>
                         <Link to={`/update/${book.isbn}`}>
                         <td>
                            
                              <button className="btn btn-primary">Update</button>
                        </td>
                        </Link>
                        <td>
                            <button className="btn btn-danger" onClick={()=>deletebook(book.isbn)}>Delete</button>
                        </td>
                       </tr>
                    ))
                }
        </tbody>
      </div>

    )
}




