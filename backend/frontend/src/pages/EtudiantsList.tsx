import { use, useEffect, useState } from 'react';
import api from '../services/api';
import './EtudianstList.css'
import { MdDelete } from "react-icons/md";
import { IoIosAddCircle } from "react-icons/io";



function EtudiantsList() {
  const [etudiants, setEtudiants] = useState([]);
  const [nouveau, setNouveau] = useState({ nom: '', email: '', bonus: 0, fraisInscription: 0,password: '' });

  const chargerEtudiants = () => {
    api.get('/etudiants')
      .then(res => setEtudiants(res.data))
      .catch(err => console.error(err));
  };

  useEffect(() => {
    chargerEtudiants();
  }, []);

  const ajouterEtudiant = () => {
    api.post('/etudiants', nouveau)
      .then(() => {
        setNouveau({ nom: '', email: '', bonus: 0, fraisInscription: 0 ,password: ''});
        chargerEtudiants();
      });
  };

  const supprimerEtudiant = (id) => {
    api.delete(`/etudiants/${id}`)
      .then(() => chargerEtudiants());
  };

  const ajouterBonus = (id) => {
    const points = parseInt(prompt("Combien de points bonus ajouter ?"), 10);
    if (!isNaN(points)) {
      api.post(`/etudiants/${id}/bonus`, { bonus: points })
        .then(() => chargerEtudiants());
    }
  };

  const appliquerReduction = () => {
    api.post('/etudiants/reduction')
      .then(() => chargerEtudiants());
  };

  return (
    <div className='container'>
      <h2>Liste des étudiants</h2>

      <h3>Ajouter un étudiant</h3>
      <input placeholder="Nom" value={nouveau.nom} onChange={e => setNouveau({ ...nouveau, nom: e.target.value })} />
      <input placeholder="Email" value={nouveau.email} onChange={e => setNouveau({ ...nouveau, email: e.target.value })} />
      <input type="number" placeholder="Bonus" value={nouveau.bonus} onChange={e => setNouveau({ ...nouveau, bonus: parseInt(e.target.value) })} />
      <input type="number" placeholder="Frais" value={nouveau.fraisInscription} onChange={e => setNouveau({ ...nouveau, fraisInscription: parseInt(e.target.value) })} />
      <input placeholder="Password" value={nouveau.password} onChange={e => setNouveau({ ...nouveau, password: e.target.value })} />
      <button onClick={ajouterEtudiant}> Ajouter</button>

      <h3>Étudiants</h3>
      <table border="0">
        <thead>
          <tr>
            <th>Nom</th>
            <th>Email</th>
            <th>Bonus</th>
            <th>Frais</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {etudiants.map(e => (
            <tr key={e.id}>
              <td>{e.nom}</td>
              <td>{e.email}</td>
              <td>{e.bonus}</td>
              <td>{e.fraisInscription}</td>
              <td>
                <button onClick={() => ajouterBonus(e.id)} className='icon'><IoIosAddCircle /></button>
                <button onClick={() => supprimerEtudiant(e.id)} className='icon'><MdDelete/></button>
                
              </td>
            </tr>
          ))}
        </tbody>
      </table>

      <button onClick={appliquerReduction}>Appliquer réduction des frais</button>
    </div>
  );
}

export default EtudiantsList;
