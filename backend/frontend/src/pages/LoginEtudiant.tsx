import { useState } from 'react';
import axios from 'axios';
import './Login.css'
import back from '../assets/login.jpg' 
import { useNavigate } from 'react-router-dom';

function LoginEtudiant({ onLoginSuccess }) {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [erreur, setErreur] = useState('');
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('http://localhost:8082/api/etudiant/login', {
        email,
        password,
      }, { withCredentials: true }); 

      if (response.data === "Connecté") {
        onLoginSuccess();
        navigate('/bonus'); 
      } else {
        setErreur("Email ou mot de passe incorrect");
      }
    } catch (error) {
      setErreur("Erreur de connexion");
    }
  };

  return (
    <div className='logcontainer'>
        <img src={back} alt="" />
     <div className="left">
     <h2>Connexion Etudiant</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Email:</label><br />
          <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} required />
        </div>
        <div>
          <label>Mot de passe:</label><br />
          <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} required />
        </div>
        <button type="submit">Se connecter</button>
      </form>
      {erreur && <p style={{color: 'red'}}>{erreur}</p>}
     </div>
    </div>
  );
}

export default LoginEtudiant;
