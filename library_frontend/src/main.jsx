import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
import './index.css'
import {createBrowserRouter,RouterProvider} from 'react-router-dom'
import 'bootstrap/dist/css/bootstrap.min.css'
import {AddBook} from './component/AddBook'
const router= createBrowserRouter(
  [
     {
         path:"/",
         element:<App/>
     },
     {
       path:"/add",
       element:<AddBook/>
     },
     {
       path:"/update/:isbn",
       element:<AddBook/>
     }
  ]
)
ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <RouterProvider router={router}>
    </RouterProvider>
  </React.StrictMode>,
)
