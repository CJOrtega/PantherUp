import React from "react";
import './LoginPage.css'
import { FaUser } from "react-icons/fa";
import { FaLock } from "react-icons/fa";
import { useNavigate } from "react-router-dom";

const LoginPage = () => {
    const navigate = useNavigate();
        const handleSubmit = (e) => {
            e.preventDefault();
            navigate("/profile");
        };

   return (
       <div className="bluebox">
           <div className="wrapper2">
               <form>
                   <h1>PantherUp</h1>
                   <h2>Marketplace</h2>
                   <h4>Exclusive selling and shopping made for FIU students only.</h4>
               </form>
           </div>
           <div className="wrapper">
               <form onSubmit={handleSubmit}>
                   <h1>User Login</h1>

                   <div className="input-box">
                       <FaUser className="icon" />
                       <input type="text" placeholder='Username' required />
                   </div>

                   <div className="input-box">
                       <FaLock className="icon" />
                       <input type="password" placeholder='Password' required />
                   </div>

                   <div className="button">
                       <button type="submit">LOGIN</button>

                   </div>
               </form>
               </div>
           </div>
   );
};


export default LoginPage;
