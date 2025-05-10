import React from 'react';
import { useNavigate } from 'react-router-dom';
import home from '../assets/home.jpg' 

const Home = () => {
  const navigate = useNavigate();

  return (
    <div className='container'>
      <div className="btn">
      <button onClick={() => navigate('/login-enseignant')}>Enseignant</button>
      <button onClick={() => navigate('/login-etudiant')}>Étudiant</button>
      </div>
      <img src={home} alt="" className='image' />
    </div>
  );
};

export default Home;
