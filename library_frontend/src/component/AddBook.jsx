import React,{useState,useEffect} from 'react'
import {Link,useParams,useNavigate} from 'react-router-dom'
import axios from 'axios'
export const AddBook = () => {
    const [title,setTitle]=useState("");
    const [author,setauthor]=useState("");
    const [genre,setgenre]=useState("");
    const [publicationYear,setpublicationYear]=useState("");
    const [publisher,setpublisher]=useState("");
    const [totalcopies,setTotalcopies]=useState(0);
  const {isbn}=useParams();
 
  const navigate=useNavigate();
    const handleSubmit=async(e)=>
        {
            e.preventDefault();
            const book={title,author,genre,publicationYear,publisher,totalcopies};
            if(isbn)
            {
                const result= await axios.put(`http://localhost:8080/api/books/updatebook?iSBN=`+isbn,book);
                navigate("/");
            }
            else{
            const result= await axios.post("http://localhost:8080/api/books/createbook",book);
            navigate("/");
            }

        }

    useEffect(()=>
    {
         if(isbn)
            {
                    const getbyid=async()=>{
                    const result=await axios.get(`http://localhost:8080/api/books/getbookbyid?iSBN=`+isbn)

                      setTitle(result.data.title);
                      setauthor(result.data.author);
                      setgenre(result.data.genre);
                      setpublicationYear(result.data.publicationYear);
                      setpublisher(result.data.publisher);
                      setTotalcopies(result.data.totalcopies);
                    }

                getbyid();

            }
    },[])
  return (
    <div className="container">
        <form onSubmit={handleSubmit}>
            <div className="form-group">
                 <label>title</label>
                 <input type="text" className="form-control" value={title} onChange={(e)=>setTitle(e.target.value)}/>
            </div>
            <div className="form-group">
            <label>Author</label>
            <input type="text" className="form-control" value={author} onChange={(e)=>setauthor(e.target.value)}/>
           </div>
           <div className="form-group">
           <label>Genre</label>
           <input type="text" className="form-control" value={genre} onChange={(e)=>setgenre(e.target.value)}/>
            </div>
            <div className="form-group">
            <label>Publication Year</label>
            <input type="text" className="form-control" value={publicationYear} onChange={(e)=>setpublicationYear(e.target.value)}/>
            </div>

            <div className="form-group">
            <label>Publisher</label>
            <input type="text" className="form-control" value={publisher} onChange={(e)=>setpublisher(e.target.value)}/>
            </div>
            <div className="form-group">
            <label>Totalcopies</label>
            <input type="text" className="form-control" value={totalcopies} onChange={(e)=>setTotalcopies(e.target.value)}/>
            </div>

            <button type="submit" className="btn btn-success">Submit</button>
            <Link to="/">
              <div className="btn btn-danger">Cancel</div>
            </Link>
        </form>

    </div>
  )
}
