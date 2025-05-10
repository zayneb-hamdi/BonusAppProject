import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';
import { useState } from 'react';
import EtudiantsList from './pages/EtudiantsList';
import LoginEnseignant from './pages/LoginEnseignant';
import LoginEtudiant from './pages/LoginEtudiant';
import Home from './pages/Home';
import BonusList from './pages/BonusList';
import './App.css'

function App() {
  const [connecte, setConnecte] = useState(false);
  const [connectetudiant,setConnectetudiant]=useState(false);

  return (
    <BrowserRouter>
      <Routes>
        {/* Page d'accueil avec les deux boutons */}
        <Route path="/home" element={<Home />} />

        {/* Login enseignant */}
        <Route
          path="/login-enseignant"
          element={<LoginEnseignant onLoginSuccess={() => setConnecte(true)} />}
        />

        {/* Login étudiant */}
        <Route path="/login-etudiant" element={<LoginEtudiant  onLoginSuccess={() => setConnectetudiant(true)}/>} />

        {/* Route protégée vers /etudiants (enseignant connecté) */}
        <Route
          path="/etudiants"
          element={
            connecte ? (
              <EtudiantsList />
            ) : (
              <Navigate to="/login-enseignant" replace />
            )
          }
        />

<Route
          path="/bonus"
          element={
            connectetudiant ? (
              <BonusList />
            ) : (
              <Navigate to="/login-etudiant" replace />
            )
          }
        />

        {/* Redirection racine vers /home */}
        <Route path="/" element={<Navigate to="/home" replace />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
