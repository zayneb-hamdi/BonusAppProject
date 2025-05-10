import React, { useEffect, useState } from 'react';

import api from '../services/api';

const BonusList = () => {
  const [bonusList, setBonusList] = useState([]);
  const [error, setError] = useState(null);

  
  const fetchBonusList = () => {
    api.get('/etudiant/bonus')
      .then(res => setBonusList(res.data))
      .catch(err => console.error(err));
  };

  useEffect(() => {
    fetchBonusList();
  }, []);



  if (error) {
    return <div>{error}</div>;
  }

  return (
    <div>
      <h1>Liste des Bonus</h1>
      {bonusList.length === 0 ? (
        <p>Aucun bonus attribué pour cet étudiant.</p>
      ) : (
        <table>
          <thead>
            <tr>
              <th>Professeur</th>
              <th>Montant</th>
              <th>Date d'attribution</th>
            </tr>
          </thead>
          <tbody>
            {bonusList.map((bonus) => (
              <tr key={bonus.id}>
                <td>{bonus.professeur.email}</td>
                <td>{bonus.montant}</td>
                <td>{new Date(bonus.dateAttribution).toLocaleString()}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
};

export default BonusList;
